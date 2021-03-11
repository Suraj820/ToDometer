/*
 * Copyright 2021 Sergio Belda Galbis
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sergiobelda.androidtodometer.util

import androidx.annotation.IntRange
import com.sergiobelda.androidtodometer.model.Task
import com.sergiobelda.androidtodometer.model.TaskState

object ProgressUtil {

    fun getTasksDoneProgress(list: List<Task>): Int =
        list.takeUnless { it.isEmpty() }?.let {
            ((it.filter { task -> task.taskState == TaskState.DONE }.size / it.size.toDouble()) * 100).toInt()
        } ?: 0

    fun getPercentage(@IntRange(from = 0, to = 100) progress: Int) =
        progress.takeIf { it in 0..100 }?.let { "$it%" } ?: "-%"
}
