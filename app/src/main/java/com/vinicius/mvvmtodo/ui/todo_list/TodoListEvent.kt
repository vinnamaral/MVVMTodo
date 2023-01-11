package com.vinicius.mvvmtodo.ui.todo_list

import com.vinicius.mvvmtodo.data.Todo

sealed class TodoListEvent {
    data class OnDeleteTodoClick(val todo: Todo): TodoListEvent()
    data class onDoneChange(val todo: Todo, val isDone: Boolean): TodoListEvent()
    object OnUndoDeleteClick: TodoListEvent()
    data class OnTodoClick(val todo: Todo): TodoListEvent()
    object OnAddTodoClick: TodoListEvent()
}
