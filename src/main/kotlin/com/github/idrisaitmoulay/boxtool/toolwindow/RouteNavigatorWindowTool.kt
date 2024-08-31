package com.github.idrisaitmoulay.boxtool.toolwindow

import com.github.idrisaitmoulay.boxtool.toolwindow.screens.Base64EncodingView
import com.github.idrisaitmoulay.boxtool.toolwindow.screens.URLEncodingView
import com.intellij.openapi.ui.ComboBox
import com.intellij.ui.components.JBPanel
import io.ktor.http.*
import java.awt.Dimension
import javax.swing.BoxLayout

enum class FeaturesOptionsEnum(private val displayName: String) {
    BASE64_ENCODER_DECODER("Base64 Encoder/Decoder"),
    URL_ENCODER_DECODER("URl Encoder/Decoder");
    override fun toString() = displayName
}

class RouteNavigatorWindowTool {
    private final val router: HashRouter = HashRouter();

    init {
        this.registerAll()
    }

    public fun getContent() = JBPanel<JBPanel<*>>().apply {
        layout = BoxLayout(this, BoxLayout.Y_AXIS)
        val selfContainer = this;
        val comboBoxField: ComboBox<FeaturesOptionsEnum> = ComboBox<FeaturesOptionsEnum>()
            .apply {
                addItem(FeaturesOptionsEnum.BASE64_ENCODER_DECODER)
                addItem(FeaturesOptionsEnum.URL_ENCODER_DECODER)
                maximumSize = Dimension(Int.MAX_VALUE, minimumSize.height) // Limite la hauteur maximale
                addActionListener {
                    actionEvent ->
                        val selectedFeature = (actionEvent.source as ComboBox<*>).selectedItem as FeaturesOptionsEnum
                        selfContainer.add(router.getContainerView(selectedFeature.toString()))
                }
            }
        val choosenKey: FeaturesOptionsEnum = FeaturesOptionsEnum.BASE64_ENCODER_DECODER;
        val content = router.getContainerView(choosenKey.toString())
        add(comboBoxField)
        add(content)
    }

    private fun registerAll() {
        router
            .register(
                FeaturesOptionsEnum.BASE64_ENCODER_DECODER.toString(),
                Base64EncodingView(),
            )
        router.register(
                FeaturesOptionsEnum.URL_ENCODER_DECODER.toString(),
                URLEncodingView(),
            )
    }
}
