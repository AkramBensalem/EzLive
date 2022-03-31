//
//  RootView.swift
//  iosApp
//
//  Created by Akram Bensalem on 31/3/2022.
//  Copyright © 2022 orgName. All rights reserved.
//


import SwiftUI
import shared



struct RootView: View {
    @ObservedObject
    private var masterRoot: ObservableValue<shared.Root>

    @ObservedObject
    private var splashRouterState: ObservableValue<RouterState<AnyObject, shared.RootSplashChild>>

    @ObservedObject
    private var authenticationRouterState: ObservableValue<RouterState<AnyObject, shared.RootAuthenticationChild>>

    init(_ masterRoot: shared.Root) {
        self.masterRoot = ObservableValue(valueOf(masterRoot))
        self.splashRouterState = ObservableValue(masterRoot.splashRouterState)
        self.authenticationRouterState = ObservableValue(masterRoot.authenticationRouterState)
    }


    var body: some View {
        ZStack(alignment: .top) {
            SplashPane(router: splashRouterState.value)
            AuthenticationPane(router: authenticationRouterState.value)
        }

    }
}


struct SplashPane: View {

    let splashChild: shared.RootSplashChild
    @State private var fadeInOut = true

    init(router: RouterState<AnyObject, shared.RootSplashChild>) {
        self.splashChild = router.activeChild.instance
    }

    var body: some View {
        switch splashChild {
        case
            let splash as shared.RootSplashChild.Splash:SplashUI(splash.component)
                .onAppear(){
                    withAnimation(Animation.easeInOut(duration: 1).repeatCount(1)){
                        fadeInOut = true
                    }
                }.opacity(fadeInOut ? 1 : 0)
            default: EmptyView()
        }
    }
}

struct AuthenticationPane: View {
    
    @State private var fadeInOut = true


    let authenticationChild: shared.RootAuthenticationChild

    init(router: RouterState<AnyObject, shared.RootAuthenticationChild>) {
        self.authenticationChild = router.activeChild.instance
    }

    var body: some View {
        switch authenticationChild {
        case
            let detail as shared.RootAuthenticationChild.SignIn: AuthenticationUI(detail.component, showToolbar: true)
                .onAppear(){
                    withAnimation(Animation.easeInOut(duration: 1).repeatCount(1)){
                        fadeInOut = true
                    }
                }.opacity(fadeInOut ? 1 : 0)
        default: EmptyView()
        }
    }
}



//struct RootView_Previews: PreviewProvider {
//    static var previews: some View {
//        RootView(RootViewPreview())
//            .previewDevice("iPhone 8")
//    }
//
//    class RootViewPreview: shared.Root {
//
//        var authenticationRouterState: Value<RouterState<AnyObject, RootAuthenticationChild>> = simpleRouterState(RootAuthenticationChild.None())
//
//        var splashRouterState: Value<RouterState<AnyObject, RootSplashChild>> = simpleRouterState(RootSplashChild.Splash(component:
//                SplashUI_Previews.StubArticleList()
//            ))
//
//    }
//}
