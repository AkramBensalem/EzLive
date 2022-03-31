//
//  SplashUI.swift
//  iosApp
//
//  Created by Akram Bensalem on 31/3/2022.
//  Copyright © 2022 orgName. All rights reserved.
//
import SwiftUI
import shared

struct SplashUI: View {

    @ObservedObject
    private var model: ObservableValue<SplashScreenInterfaceModel>
    
    @State var wave : Bool = false
    @State var imageSize : Double = 0.33
    
    
    let timer = Timer.publish(every: 0.5, on: .main, in: .common).autoconnect()
    
    
    private let delay = Delay(_secondes: 3)

    private let component: SplashScreenInterface

    init(_ component: SplashScreenInterface) {
        self.model = ObservableValue(component.model)
        self.component = component
        
        delay.performWork {
            
            component.onTimeFinished(state: 1)
        }
    }

    var body: some View {
        GeometryReader { metrics in
        VStack {
            Spacer()
            
            Image(model.value.image.replacingOccurrences(of: ".png", with: ""))
                    .resizable()
                    .frame(width: min(metrics.size.width, metrics.size.width) * 0.33, height: min(metrics.size.width, metrics.size.width) * 0.33, alignment: .center)
                    .shadow(radius: 16)
                    .scaleEffect(wave ? 1.2 : 0.8)
                    .animation(Animation.easeInOut(duration: 0.8).repeatForever(autoreverses: true).speed(1))
                    .onAppear(){
                        self.wave.toggle()
                    }
                   
            Spacer()
            Text(model.value.title)
                .multilineTextAlignment(.center)
                .padding(.all, 16.0)
                .padding(.bottom, 16.0)
                .frame(maxWidth: .infinity, alignment: .bottom)
                .font(.custom("merriweather_bold", size: 24).weight(.bold)).foregroundColor(Color.white)
        
                .onReceive(timer){ _ in
                    component.onUpdateTitle()
                }

        }.frame(maxWidth: .infinity,maxHeight: .infinity)
            .background(Color(UIColor(named: "surface")!))
    }
    }
}

struct SplashUI_Previews: PreviewProvider {
    static var previews: some View {
        SplashUI(StubArticleList())
    }

    class StubArticleList: SplashScreenInterface {
        func onTimeFinished(state: Int64) { }
        func onUpdateTitle() { }

        var model: Value<SplashScreenInterfaceModel> = valueOf(SplashScreenInterfaceModel(
        title: "Ezlive...",
        image : "logo",
        state : "1"))
    }
}
