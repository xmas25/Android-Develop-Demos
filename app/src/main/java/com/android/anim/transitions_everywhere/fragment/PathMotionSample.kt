/*
 * Copyright (C) 2016 Andrey Kulikov (andkulikov@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.anim.transitions_everywhere.fragment

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout

import com.android.R
import com.kotlinlib.other.LayoutId
import com.kotlinlib.view.KotlinFragment
import com.transitionseverywhere.ArcMotion
import com.transitionseverywhere.ChangeBounds
import com.transitionseverywhere.TransitionManager
import kotlinx.android.synthetic.main.button.*
import kotlinx.android.synthetic.main.fragment_path.*

/**
 * Created by Andrey Kulikov on 24/03/16.
 */
@LayoutId(R.layout.fragment_path)
class PathMotionSample : KotlinFragment() {

    override fun init() {

        var mToRightAnimation = false

        button.click {
            val changeBounds = ChangeBounds()
            changeBounds.pathMotion = ArcMotion()
            changeBounds.duration = 500
            TransitionManager.beginDelayedTransition(transitions_container, changeBounds)

            mToRightAnimation = !mToRightAnimation
            val params = button.layoutParams as FrameLayout.LayoutParams
            params.gravity = if (mToRightAnimation)
                Gravity.RIGHT or Gravity.BOTTOM
            else
                Gravity.LEFT or Gravity.TOP
            button.layoutParams = params
        }

        header.setRightClick {
            getAct().codeDialog.text("""
var mToRightAnimation = false

button.click {
    val changeBounds = ChangeBounds()
    changeBounds.pathMotion = ArcMotion()
    changeBounds.duration = 500
    TransitionManager.beginDelayedTransition(transitions_container, changeBounds)

    mToRightAnimation = !mToRightAnimation
    val params = button.layoutParams as FrameLayout.LayoutParams
    params.gravity = if (mToRightAnimation)
        Gravity.RIGHT or Gravity.BOTTOM
    else
        Gravity.LEFT or Gravity.TOP
    button.layoutParams = params
}
            """.trimIndent())
        }
    }
}
