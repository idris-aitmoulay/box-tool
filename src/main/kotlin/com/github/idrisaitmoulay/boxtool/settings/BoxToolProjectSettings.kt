package com.github.idrisaitmoulay.boxtool.settings

import com.intellij.openapi.options.BoundConfigurable
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogPanel
import com.intellij.ui.layout.panel

const val BOX_TOOL_PROJECT_SETTINGS_TITLE: String = "Box Tool Settings";

class BoxToolProjectSettings(private val project: Project) : BoundConfigurable("GitLab Project Settings") {
    override fun createPanel(): DialogPanel {
        return panel {
            row {
                cell {
                    label(BOX_TOOL_PROJECT_SETTINGS_TITLE)
                }
            }
        }
    }
}
