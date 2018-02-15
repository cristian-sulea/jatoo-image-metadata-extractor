/*
 * Copyright (C) Cristian Sulea ( http://cristian.sulea.net )
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jatoo.image.metadata.extractor;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.exif.ExifIFD0Directory;

import jatoo.image.ImageMetadata;
import jatoo.image.ImageMetadataHandler;

/**
 * ExifTool {@link ImageMetadataHelper} implementation.
 * 
 * @author <a href="http://cristian.sulea.net" rel="author">Cristian Sulea</a>
 * @version 1.0, February 15, 2018
 */
public class ExtractorImageMetadataHandler extends ImageMetadataHandler {

  /** The logger. */
  private static final Log logger = LogFactory.getLog(ExtractorImageMetadataHandler.class);

  @Override
  public int getOrientation(File image) {

    try {
      Metadata metadata = ImageMetadataReader.readMetadata(image);
      Directory directory = metadata.getFirstDirectoryOfType(ExifIFD0Directory.class);

      if (directory != null) {
        return directory.getInt(ExifIFD0Directory.TAG_ORIENTATION);
      }
    }

    catch (ImageProcessingException | IOException | MetadataException e) {
      logger.error("could not get orientation", e);
    }

    return 0;
  }

  private String getNotImplementedExceptionText() {
    return "method not implemented, or operation not supported";
  }

  @Override
  public ImageMetadata getMetadata(File image) {
    throw new IllegalStateException(getNotImplementedExceptionText());
  }

  @Override
  public boolean copyMetadata(File srcImage, File dstImage) {
    throw new IllegalStateException(getNotImplementedExceptionText());
  }

  @Override
  public boolean removeMetadata(File image) {
    throw new IllegalStateException(getNotImplementedExceptionText());
  }

  @Override
  public Date getDateTimeOriginal(File image) {
    throw new IllegalStateException(getNotImplementedExceptionText());
  }

  @Override
  public boolean setDateTimeOriginal(File image, Date date) {
    throw new IllegalStateException(getNotImplementedExceptionText());
  }

  @Override
  public Map<File, Date> getDateTimeOriginalForFolder(File folder) {
    throw new IllegalStateException(getNotImplementedExceptionText());
  }

}
