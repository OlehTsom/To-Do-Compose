package com.example.to_docompose.utils

//Це перерахування, яке містить різні дії, які можна виконати на екрані "list".
// Ці дії використовуються для визначення конкретного шляху навігації при виклику

enum class Action {
    ADD,
    DELETE,
    UPDATE,
    DELETE_ALL,
    UNDO,
    NO_ACTION
}