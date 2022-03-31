//
//  SimpleRouterState.swift
//  iosApp
//
//  Created by Akram Bensalem on 31/3/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import shared

func simpleRouterState<T : AnyObject>(_ child: T) -> Value<RouterState<AnyObject, T>> {
    return valueOf(
        RouterState(
            activeChild: ChildCreated(
                configuration: "config" as AnyObject,
                instance: child
            ),
            backStack: []
        )
    )
}

