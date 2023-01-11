package com.vinicius.mvvmtodo.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo: Todo)

    @Delete
    suspend fun deleteTodo(todo: Todo)

    @Query("SELECT * FROM todo WHERE id = :id")
    suspend fun getTodoById(id: Int): Todo?

    // Isso é uma coisa legal do room, nós podemos retornar um Flow
    // Flow é um real-time updates na nossa database
    // O Flow serve para termos sempre uma lista atualizada, mesmo após mudanças na lista de Todos
    // Toda vez que algo mudar, o trigger do Flow será ativado para termos uma lista atualizada
    @Query("SELECT * FROM todo")
    fun getTodos(): Flow<List<Todo>>
}