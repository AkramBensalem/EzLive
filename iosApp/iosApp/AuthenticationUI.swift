//
//  AuthenticationUI.swift
//  iosApp
//
//  Created by Akram Bensalem on 31/3/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct AuthenticationUI: View {

    @ObservedObject
    private var model: ObservableValue<AuthenticationScreenInterfaceModel>

    private let component: AuthenticationScreenInterface

    private let showToolbar: Bool

    init(_ component: AuthenticationScreenInterface, showToolbar: Bool) {
        self.showToolbar = showToolbar
        self.component = component
        self.model = ObservableValue(component.models)
    }

    var body: some View {

        let articleText = model.value.article.text

        if showToolbar {
            NavigationView {
                VStack {
                    articleDetailView(text: articleText)
                }.navigationBarTitle(Text(model.value.article.title), displayMode: .inline).navigationBarItems(leading:
                        Image(systemName: "arrow.backward")
                        .aspectRatio(contentMode: .fit).imageScale(.large)
                        .foregroundColor(.blue).onTapGesture {
                        component.onCloseClicked() })
            }
        } else {
            articleDetailView(text: articleText)
        }
    }
}

func articleDetailView(text: String) -> some View {
    return ScrollView {
        Text(text).padding([.top, .leading, .trailing]).lineLimit(nil)
    }
}

struct AuthenticationUI_Previews: PreviewProvider {
    static var previews: some View {
        AuthenticationUI(StubArticleDetail(), showToolbar: true)
            .previewDevice("iPhone 8")
    }

    class StubArticleDetail: AuthenticationScreenInterface {
        func onCloseClicked() { }

        var models: Value<AuthenticationScreenInterfaceModel> = valueOf(AuthenticationScreenInterfaceModel(
            isToolbarVisible: false,
            article: AuthenticationScreenInterfaceArticle(title: "You can use this approach to create loops of any type. For example, this code ", text: "You can use this approach to create loops of any type. For example, this code creates an array of three colors, loops over them all, and creates text views using each color name and color value:, u can use this approach to create loops of any type. For example, this code creates an array of three colors, loops over them all, and creates text views using each , u can use this approach to create loops of any type. For example, this code creates an array of three colors, loops over them all, and creates text views using each u can use this approach to create loops of any type. For example, this code creates an array of three colors, loops over them all, and creates text views using each u can use this approach to create loops of any type. For example, this code creates an array of three colors, loops over them all, and creates text views using each u can use this approach to create loops of any type. For example, this code creates an array of three colors, loops over them all, and creates text views using each u can use this approach to create loops of any type. For example, this code creates an array of three colors, loops over them all, and creates text views using each u can use this approach to create loops of any type. For example, this code creates an array of three colors, loops over them all, and creates text views using each u can use this approach to create loops of any type. For example, this code creates an array of three colors, loops over them all, and creates text views using each u can use this approach to create loops of any type. For example, this code creates an array of three colors, loops over them all, and creates text views using each ")))
    }

}

