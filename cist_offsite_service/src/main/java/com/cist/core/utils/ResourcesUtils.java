package com.cist.core.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Properties;

public class ResourcesUtils
{
  public static URL getResourceURL(String resource)
    throws IOException
  {
    URL url = null;
    ClassLoader loader = ResourcesUtils.class.getClassLoader();
    if (loader != null) {
      url = loader.getResource(resource);
    }
    if (url == null) {
      url = ClassLoader.getSystemResource(resource);
    }
    if (url == null) {
      throw new IOException("Could not find resource " + resource);
    }
    return url;
  }

  public static URL getResourceURL(ClassLoader loader, String resource)
    throws IOException
  {
    URL url = null;
    if (loader != null) {
      url = loader.getResource(resource);
    }
    if (url == null) {
      url = ClassLoader.getSystemResource(resource);
    }
    if (url == null) {
      throw new IOException("Could not find resource " + resource);
    }
    return url;
  }

  public static InputStream getResourceAsStream(String resource)
    throws IOException
  {
    InputStream in = null;
    ClassLoader loader = ResourcesUtils.class.getClassLoader();
    if (loader != null) {
      in = loader.getResourceAsStream(resource);
    }
    if (in == null) {
      in = ClassLoader.getSystemResourceAsStream(resource);
    }
    if (in == null) {
      throw new IOException("Could not find resource " + resource);
    }
    return in;
  }

  public static InputStream getResourceAsStream(ClassLoader loader, String resource)
    throws IOException
  {
    InputStream in = null;
    if (loader != null) {
      in = loader.getResourceAsStream(resource);
    }
    if (in == null) {
      in = ClassLoader.getSystemResourceAsStream(resource);
    }
    if (in == null) {
      throw new IOException("Could not find resource " + resource);
    }
    return in;
  }

  public static Properties getResourceAsProperties(String resource)
    throws IOException
  {
    Properties props = new Properties();
    InputStream in = null;
    String propfile = resource;
    in = getResourceAsStream(propfile);
    props.load(in);
    in.close();
    return props;
  }

  public static Properties getResourceAsProperties(ClassLoader loader, String resource)
    throws IOException
  {
    Properties props = new Properties();
    InputStream in = null;
    String propfile = resource;
    in = getResourceAsStream(loader, propfile);
    props.load(in);
    in.close();
    return props;
  }

  public static InputStreamReader getResourceAsReader(String resource)
    throws IOException
  {
    return new InputStreamReader(getResourceAsStream(resource));
  }

  public static Reader getResourceAsReader(ClassLoader loader, String resource)
    throws IOException
  {
    return new InputStreamReader(getResourceAsStream(loader, resource));
  }

  public static File getResourceAsFile(String resource)
    throws IOException
  {
    return new File(SystemUtils.getFileDirectory(getResourceURL(resource).getFile()));
  }

  public static File getResourceAsFile(ClassLoader loader, String resource)
    throws IOException
  {
    return new File(getResourceURL(loader, resource).getFile());
  }
}