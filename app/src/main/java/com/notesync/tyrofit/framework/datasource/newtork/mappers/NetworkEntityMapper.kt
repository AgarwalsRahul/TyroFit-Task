package com.notesync.tyrofit.framework.datasource.newtork.mappers

import com.notesync.tyrofit.businesss.domain.model.Cardio
import com.notesync.tyrofit.businesss.domain.util.EntityMapper
import com.notesync.tyrofit.framework.datasource.newtork.models.CardioDto


class NetworkEntityMapper : EntityMapper<CardioDto, Cardio> {
    override fun mapFromEntity(entity: CardioDto): Cardio {
        return Cardio(
            entity.id,
            entity.name,
            entity.category_id,
            entity.trainer_id,
            entity.image,
            entity.duration.toString(),// to be converted
            entity.min_calories,
            entity.max_calories,
            entity.description,
            entity.difficulty_level,
            entity.createdAt.toString(),//to be converted
            entity.updatedAt?.toString(),
            entity.video,
            entity.video_updatedAt?.toString(),
            entity.equipments,
            emptyList(),
            entity.trainer_name,
            entity.difficulty_level_name,
            entity.category_name
        )
    }

    override fun mapToEntity(domainModel: Cardio): CardioDto {
        return CardioDto(
            domainModel.id,
            domainModel.name,
            domainModel.category_id,
            domainModel.trainer_id,
            domainModel.image,
            domainModel.duration.toLong(),// to be converted
            domainModel.min_calories,
            domainModel.max_calories,
            domainModel.description,
            domainModel.difficulty_level,
            domainModel.createdAt.toLong(),//to be converted
            domainModel.updatedAt?.toLong(),
            domainModel.video,
            domainModel.video_updatedAt?.toLong(),
            domainModel.equipments,
            emptyList(),
            domainModel.trainer_name,
            domainModel.difficulty_level_name,
            domainModel.category_name
        )
    }

}