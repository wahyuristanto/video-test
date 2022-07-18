package com.nioso.core.util

import android.content.Context
import android.text.Editable
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.google.gson.GsonBuilder
import com.nioso.core.base.BaseResponse
import com.nioso.core.base.BaseResult
import com.riztech.vidiotest.BuildConfig
import com.riztech.vidiotest.R
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

val Editable.value
    get() = this.toString()

fun Editable.extractNumber(): Int {
    return try {
        this.toString().toInt()
    } catch (e: Exception) {
        0
    }
}

val EditText.value
    get() = this.text ?: ""

fun hideKeyboard(context: Context?, view: View?) {
    context?.let { ctx ->
        val imm = ctx.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        view?.let {
            imm.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }
}

fun applyPixelToDp(context: Context, value: Int): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        value.toFloat(),
        context.resources.displayMetrics
    ).toInt()
}


suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher,
    apiCall: suspend () -> T
): BaseResult<T> {

    return withContext(dispatcher) {
        try {
            BaseResult.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> BaseResult.Error(throwable.message, null)
                is HttpException -> {
//                    val code = throwable.code()
                    val errorResponse = convertErrorBody(throwable)
                    BaseResult.Error(errorResponse?.message ?: "Server Error", null)
                }
                else -> {
                    BaseResult.Error(null, null)
                }
            }
        }
    }
}


private fun convertErrorBody(throwable: HttpException): BaseResponse<*>? {
    return try {
        throwable.response()?.errorBody()?.byteString()?.utf8()?.let {
            GsonBuilder().create().fromJson(it, BaseResponse::class.java)
        }
    } catch (exception: Exception) {
        null
    }
}

fun ImageView.load(value: Any) {
    val options = RequestOptions().error(R.mipmap.ic_launcher)
    Glide.with(this).setDefaultRequestOptions(options).load(value).into(this)
}

fun getProgressDrawable(context: Context) : CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        centerRadius = 20f
        start()
    }
}

fun ImageView.loadImage(uri: String?, progressDrawable: CircularProgressDrawable, context: Context){
    val options = RequestOptions()
        .skipMemoryCache(true)
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .placeholder(progressDrawable)
        .error(R.mipmap.ic_launcher_round)

    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(uri)
        .into(this)
}

fun ImageView.loadCircle(value: Any) {
    val options = RequestOptions()
        .placeholder(R.mipmap.ic_launcher)
        .error(R.mipmap.ic_launcher)

    Glide.with(this).setDefaultRequestOptions(options).load(value).circleCrop().into(this)
}

fun View.isDisplayed(value: Boolean) {
    this.visibility = when (value) {
        true -> View.VISIBLE
        false -> View.GONE
    }
}

fun incrementIdlingResource(){
    if (BuildConfig.DEBUG){
        EspressoIdlingResource.increment()
    }
}

fun decrementIdlingResource(){
    if (BuildConfig.DEBUG){
        if (!EspressoIdlingResource.idlingresource.isIdleNow) {
            //Memberitahukan bahwa tugas sudah selesai dijalankan
            EspressoIdlingResource.decrement()
        }
    }
}

internal fun View?.findSuitableParent(): ViewGroup? {
    var view = this
    var fallback: ViewGroup? = null
    do {
        if (view is CoordinatorLayout) {
            // We've found a CoordinatorLayout, use it
            return view
        } else if (view is FrameLayout) {
            if (view.id == android.R.id.content) {
                // If we've hit the decor content view, then we didn't find a CoL in the
                // hierarchy, so use it.
                return view
            } else {
                // It's not the content view but we'll use it as our fallback
                fallback = view
            }
        }

        if (view != null) {
            // Else, we will loop and crawl up the view hierarchy and try to find a parent
            val parent = view.parent
            view = if (parent is View) parent else null
        }
    } while (view != null)

    // If we reach here then we didn't find a CoL or a suitable content view so we'll fallback
    return fallback
}

fun RecyclerView.init(
    ctx: Context,
    type: String = "linear",
    horizontal: Boolean = false,
    reverseLayout: Boolean = false,
    column: Int = 2
) {
    if (type.equals("linear", true)) {
        if (horizontal) {
            this.layoutManager =
                LinearLayoutManager(ctx, LinearLayoutManager.HORIZONTAL, reverseLayout)
        } else {
            this.layoutManager =
                LinearLayoutManager(ctx, LinearLayoutManager.VERTICAL, reverseLayout)
        }
    } else if (type.equals("grid", true)) {
        this.layoutManager = GridLayoutManager(context, column)
    } else {
    }
}

fun View.hide() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}