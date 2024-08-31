package com.github.idrisaitmoulay.boxtool.toolwindow.screens

import com.github.idrisaitmoulay.boxtool.crypto.AbstractEncoding
import com.github.idrisaitmoulay.boxtool.crypto.Base64Encoding
import com.intellij.ui.components.JBPanel
import com.intellij.ui.components.JBTextArea
import com.intellij.notification.NotificationGroupManager
import com.intellij.notification.NotificationType
import com.intellij.openapi.project.getOpenedProjects
import com.intellij.ui.util.preferredHeight
import java.awt.Dimension
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import javax.swing.BoxLayout
import javax.swing.JButton
import javax.swing.JPanel


const val ENCODER_BUTTON_TITLE = "Encoder"
const val DECODER_BUTTON_TITLE = "Decoder"
const val TEXT_AREA_PREFERRED_HEIGHT = 150
private val NOTIFICATION_GROUP_ID = "BoxToolNotifications"
private val notificationGroup = NotificationGroupManager.getInstance()
    .getNotificationGroup(NOTIFICATION_GROUP_ID)
abstract class AbstractEncodingView: AbstractView() {
    override fun getContainer(): JPanel {
        return JBPanel<JBPanel<*>>().apply {
            layout = BoxLayout(this, BoxLayout.Y_AXIS)
            val outputTextArea = JBTextArea().apply {
                preferredHeight = TEXT_AREA_PREFERRED_HEIGHT
                lineWrap = true
                enable(false)
            }
            val userInputTextArea = JBTextArea().apply {
                preferredHeight = TEXT_AREA_PREFERRED_HEIGHT
                lineWrap = true
            }
            add(JBPanel<JBPanel<*>>().apply {
                layout = java.awt.GridLayout(3, 1, 6, 6)
                add(userInputTextArea)
                add(outputTextArea)
            })
            add(JBPanel<JBPanel<*>>().apply {
                layout = java.awt.GridLayout(2, 1, 6, 6)
                add(JButton(ENCODER_BUTTON_TITLE).apply {
                    addActionListener {
                        maximumSize = Dimension(Int.MAX_VALUE, minimumSize.height) // Limite la hauteur maximale
                        val encoded = getEncoder().encode(userInputTextArea.text)
                        outputTextArea.text = encoded
                        copyPaste(encoded)
                    }
                })
                add(JButton(DECODER_BUTTON_TITLE).apply {
                    addActionListener {
                        maximumSize = Dimension(Int.MAX_VALUE, minimumSize.height) // Limite la hauteur maximale
                        val decoded = getEncoder().decode(userInputTextArea.text)
                        outputTextArea.text = decoded
                        copyPaste(decoded)
                    }
                })
            })
        }
    }

    private fun copyPaste(modifiedText: String) {
        val clipboard = Toolkit.getDefaultToolkit().systemClipboard
        clipboard.setContents(StringSelection(modifiedText), null)
        val notification = notificationGroup.createNotification("Copied", NotificationType.INFORMATION)
        notification.notify(getOpenedProjects().last())
    }

    abstract fun getEncoder(): AbstractEncoding
}