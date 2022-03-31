//
//  MutableStateBuilder.swift
//  iosApp
//
//  Created by Akram Bensalem on 30/3/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared

func valueOf<T: AnyObject>(_ value: T) -> Value<T> {
    return MutableValueBuilderKt.MutableValue(initialValue: value) as! MutableValue<T>
}

