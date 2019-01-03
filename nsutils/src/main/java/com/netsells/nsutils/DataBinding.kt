package com.netsells.nsutils

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.*
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("app:onClick")
fun setOnClick(view: View, onClickListener: View.OnClickListener) {
    view.setOnClickListener(onClickListener)
    view.isClickable = true
}

@BindingAdapter("app:onLongClick")
fun setOnLongClick(view: View, onLongClickListener: View.OnLongClickListener) {
    view.setOnLongClickListener(onLongClickListener)
    view.isLongClickable = true
}

@BindingAdapter("android:progress")
fun setProgress(view: SeekBar, newValue: Int) {
    if (view.progress != newValue) {
        view.progress = newValue
    }
}

@InverseBindingAdapter(attribute = "android:progress")
fun getProgress(view: SeekBar): Int {
    return view.progress
}

@BindingAdapter("android:progressAttrChanged")
fun setSeekBarListener(view: SeekBar, attrChange: InverseBindingListener) {
    view.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            attrChange.onChange()
        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {

        }

        override fun onStopTrackingTouch(seekBar: SeekBar?) {

        }
    })
}

@BindingAdapter("android:text")
fun setText(view: EditText, newValue: String?) {
    if (view.text?.toString() != newValue) {
        view.setText(newValue)
    }
}

@InverseBindingAdapter(attribute = "android:text")
fun getText(view: EditText): String? = view.text?.toString()

@BindingAdapter("android:textAttrChanged")
fun setTextChangeListener(view: EditText, attrChange: InverseBindingListener) {
    view.addTextWatcher { _, _, _, _ -> attrChange.onChange() }
}

@BindingAdapter("android:checked")
fun setChecked(view: CheckBox, newValue: Boolean?) {
    if (view.isChecked != newValue) {
        view.isChecked = newValue.orFalse()
    }
}

@InverseBindingAdapter(attribute = "android:checked")
fun getChecked(view: CheckBox): Boolean = view.isChecked

@BindingAdapter("android:checkedAttrChanged")
fun setCheckedChangedListener(view: CheckBox, attrChange: InverseBindingListener) {
    view.setOnCheckedChangeListener { _, _ -> attrChange.onChange() }
}

@BindingAdapter("android:checked")
fun setChecked(view: Switch, newValue: Boolean?) {
    if (view.isChecked != newValue) {
        view.isChecked = newValue.orFalse()
    }
}

@InverseBindingAdapter(attribute = "android:checked")
fun getChecked(view: Switch): Boolean = view.isChecked

@BindingAdapter("android:checkedAttrChanged")
fun setCheckedChangedListener(view: Switch, attrChange: InverseBindingListener) {
    view.setOnCheckedChangeListener { _, _ -> attrChange.onChange() }
}

@BindingAdapter("android:src")
fun setSrc(view: ImageView, newValue: Drawable?) {
    if (view.drawable != newValue) {
        view.setImageDrawable(newValue)
    }
}

@BindingAdapter("android:drawableEnd")
fun setDrawableEnd(view: TextView, newValue: Drawable?) {
    view.setCompoundDrawablesWithIntrinsicBounds(null, null, newValue, null)
}

@BindingAdapter("android:drawableStart")
fun setDrawableStart(view: TextView, newValue: Drawable?) {
    view.setCompoundDrawablesWithIntrinsicBounds(newValue, null, null, null)
}

@BindingAdapter("android:drawableTop")
fun setDrawableTop(view: TextView, newValue: Drawable?) {
    view.setCompoundDrawablesWithIntrinsicBounds(null, newValue, null, null)
}

@BindingAdapter("android:drawableBottom")
fun setDrawableBottom(view: TextView, newValue: Drawable?) {
    view.setCompoundDrawablesWithIntrinsicBounds(null, null, null, newValue)
}

@BindingAdapter("android:src")
fun setNetworkImage(view: ImageView, newValue: String?) {
    Glide.with(view.context)
        .load(newValue)
        .apply(RequestOptions.centerCropTransform())
        .into(view)
}