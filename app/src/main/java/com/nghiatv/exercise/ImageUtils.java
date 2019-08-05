package com.nghiatv.exercise;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ImageUtils {
    public static Bitmap loadImage(String path) {
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        retriever.setDataSource(path);

        if (retriever.getEmbeddedPicture() != null) {
            InputStream inputStream = new ByteArrayInputStream(retriever.getEmbeddedPicture());
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            retriever.release();
            return bitmap;
        }

        return null;
    }
}
