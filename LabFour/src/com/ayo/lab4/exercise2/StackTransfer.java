package com.ayo.lab4.exercise2;


public static <E> void transfer(Stack<E> S, Stack<E> T) {
    while (!S.isEmpty()) {
        T.push(S.pop());
    }
}



