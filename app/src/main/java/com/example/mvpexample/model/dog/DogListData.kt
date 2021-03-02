package com.example.mvpexample.model.dog

object DogListData {

    fun getDoglistData(): List<Dog> {
        return listOf(
            Dog("Maltese",3),
            Dog("Golden Retriever",5),
            Dog("Siberian Husky",2)
        )
    }
}