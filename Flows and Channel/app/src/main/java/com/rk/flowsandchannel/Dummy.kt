package com.rk.flowsandchannel

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

fun getNotes(): Flow<Notes> {
    val list = listOf(
        Notes(1, true, "Title 1", "Description 1"),
        Notes(2, false, "Title 2", "Description 2"),
        Notes(3, true, "Title 3", "Description 3"),
        Notes(4, true, "Title 4", "Description 4"),
    )

    return  list.asFlow()
}