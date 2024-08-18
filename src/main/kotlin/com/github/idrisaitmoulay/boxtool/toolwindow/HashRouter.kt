package com.github.idrisaitmoulay.boxtool.toolwindow

import com.github.idrisaitmoulay.boxtool.toolwindow.screens.AbstractView
import javax.swing.JPanel

class HashRouter {
    private val routes: HashMap<String, AbstractView> =  HashMap();

    public fun register(pathname: String, view: AbstractView) {
        this.routes.set(pathname, view)
    }

    public fun getContainerView(pathname: String): JPanel {
        var view: AbstractView? = this.routes.get(pathname);
        if (view == null) {
            return error("Unknown View");
        }
        return view.getInstanciatedContainer();
    }
}