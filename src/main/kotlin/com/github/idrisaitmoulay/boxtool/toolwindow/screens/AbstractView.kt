package com.github.idrisaitmoulay.boxtool.toolwindow.screens
import javax.swing.JPanel

abstract class AbstractView {
    private var container: JPanel? = null;

    abstract fun getContainer(): JPanel

    fun getInstanciatedContainer(): JPanel {
        if (container == null) {
            container = this.getContainer()
        }
        return container as JPanel;
    }
}