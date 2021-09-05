package com.davidnardya.flickrgalleryapp.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.davidnardya.flickrgalleryapp.api.SimpleApi
import com.davidnardya.flickrgalleryapp.model.Image
import java.lang.Exception


class ImagePagingSource(val apiService: SimpleApi): PagingSource<Int, Image>() {

    override fun getRefreshKey(state: PagingState<Int, Image>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Image> {
        return try {
            val nextPage = (params.key ?: FIRST_PAGE_INDEX)
            var response = apiService.getImages2(nextPage)

            LoadResult.Page(
                data = response.photos.photo,
                prevKey = null,
                nextKey = if (response.photos.photo.isEmpty()) null else nextPage + 1
            )
        }
        catch (e: Exception){
            LoadResult.Error(e)
        }
    }

    companion object {
        private const val FIRST_PAGE_INDEX = 1
    }
}