package ui.theme.image

import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*
import ui.theme.AppCSSVariables
import ui.theme.EzLiveStylesheet

object WtImages : StyleSheet(EzLiveStylesheet) {

    @OptIn(ExperimentalComposeWebApi::class)
    val pulse by keyframes {
        each(0.percent){
            this.transform {
                scale(0.8)
            }

            this.filter {
                dropShadow(.0.cssRem, .0.cssRem, 100.px,rgba(255,82,82,0))
            }
        }
        each(50.percent){
            this.transform {
                scale(1.2)
            }
           this.filter {
                dropShadow( 10.px, 10.px, 100.px,rgba(255,82,82,0.2))
            }
        }
        each(100.percent){
            this.transform {
                scale(0.8)
            }
            this.filter {
                dropShadow(.0.cssRem, .0.cssRem, 100.px,rgba(255,82,82,0))
            }
        }

    }



    val wtLogo by style {
        width(33.percent)
        height(33.percent)
        borderRadius(100.percent)
        backgroundColor(Color.transparent)
        margin(0.px)
        padding(0.px)
        top(0.px)
        bottom(0.px)
        left(0.px)
        right(0.px)
        animation(pulse) {
            duration(1.6.s)
            timingFunction(AnimationTimingFunction.Linear)
            iterationCount(null)
        }
        property("object-fit","contain")
    }

    val wtLogoDiv by style {
        display(DisplayStyle.Flex)
        justifyContent(JustifyContent.Center)
        alignItems(AlignItems.Center)
        margin(0.px)
        padding(0.cssRem)
        top(0.px)
        bottom(0.px)
        left(0.px)
        right(0.px)
    }

    val wtTextDiv by style {
        display(DisplayStyle.Flex)
        justifyContent(JustifyContent.Center)
        alignItems(AlignItems.Center)
        position(Position.Absolute)
        margin(0.px)
        padding(0.cssRem)
        bottom(0.px)
        left(0.px)
        right(0.px)
    }



}