package com.dilara.vitrinovanew.data.model

data class Category (
    val children: List<CategoryChildren>,
    val cover: Cover,
    val id: Int,
    val logo: Cover,
    val name: String,
    val order: Int,
    val parent_category: ParentCategory?,
    val parent_id: Int?
        )