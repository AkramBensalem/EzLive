//
//  Delay.swift
//  iosApp
//
//  Created by Akram Bensalem on 31/3/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation

class Delay {
    
    private var secondes : Double
    
    init(_secondes : Double = 4){
        self.secondes = _secondes
    }
    
    var workItem : DispatchWorkItem?
    
    func performWork(_work : @escaping () -> Void ){
        workItem = DispatchWorkItem(block: {
            _work()
        })
        
        DispatchQueue.main.asyncAfter(deadline: .now() + secondes, execute: workItem!)
    }
    
    func cancel(){
        workItem?.cancel()
    }
    
}
