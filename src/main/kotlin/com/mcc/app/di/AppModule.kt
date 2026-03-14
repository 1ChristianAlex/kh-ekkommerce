package com.mcc.app.di

import com.mcc.app.adapter.output.exposed.MemoryConnection
import io.ktor.server.application.*
import io.ktor.server.plugins.di.*
import org.jetbrains.exposed.v1.jdbc.Database

fun Application.appModuleDI() {
    dependencies {

//        provide<BaseRepository<Product>> {
//            ExposedProductRepositoryIml(
//                resolve<Database>(),
//                mapper = resolve<BaseMapper<ProductEntity, Product>>(),
//            )
//        }
//        provide<BaseMapper<ProductEntity, Product>> {
//            ExposedProductMapperImpl(
//                brandMapper = resolve<BaseMapper<BrandEntity, BrandProduct>>(),
//                categoryMapper = resolve<BaseMapper<CategoryEntity, CategoryProduct>>(),
//                attributesMapper = resolve<BaseMapper<AttributeEntity, AttributesProduct>>(),
//                mediaMapper = resolve<BaseMapper<FileEntity, FileProduct>>(),
//                statusMapper = resolve<BaseMapper<StatusEntity, ProductStatus>>(),
//            )
//        }
//        provide<BaseMapper<BrandEntity, BrandProduct>> {
//            ExposedBrandMapperImpl()
//        }
//        provide<BaseMapper<CategoryEntity, CategoryProduct>> {
//            ExposedCategoryMapperImpl()
//        }
//        provide<BaseMapper<AttributeEntity, AttributesProduct>> { ExposedAttributeMapperImpl() }
//        provide<BaseMapper<FileEntity, FileProduct>> { ExposedMediaMapperImpl() }
//        provide<BaseMapper<StatusEntity, ProductStatus>> { ExposedStatusMapperImpl() }
    }
}