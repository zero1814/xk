package org.file.util;

import java.io.ByteArrayInputStream;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.OSSObject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AliyunOssUtil {

	/**
	 * 
	 * 方法: createBucket <br>
	 * 描述: 创建存储空间 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年6月3日 下午5:29:21
	 * 
	 * @param ossClient
	 * @param bucketName
	 * @return
	 */
	public static String createBucket(OSS ossClient, String bucketName) {
		// 存储空间
		final String bucketNames = bucketName;
		if (!ossClient.doesBucketExist(bucketName)) {
			// 创建存储空间
			Bucket bucket = ossClient.createBucket(bucketName);
			log.info("创建存储空间成功");
			return bucket.getName();
		}
		return bucketNames;
	}

	/**
	 * 
	 * 方法: deleteBucketByName <br>
	 * 描述: 删除存储空间 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年6月3日 下午5:29:57
	 * 
	 * @param ossClient
	 * @param bucketName
	 *            存储空间名称
	 */
	public static void deleteBucketByName(OSS ossClient, String bucketName) {
		ossClient.deleteBucket(bucketName);
		log.info("删除" + bucketName + "Bucket成功");
	}

	/**
	 * 
	 * 方法: createFolder <br>
	 * 描述: 创建模拟文件夹 <br>
	 * 作者: zhy<br>
	 * 时间: 2019年6月3日 下午5:30:48
	 * 
	 * @param ossClient
	 * @param bucketName
	 * @param folder
	 * @return
	 */
	public static String createFolder(OSS ossClient, String bucketName, String folder) {
		// 文件夹名
		final String keySuffixWithSlash = folder;
		// 判断文件夹是否存在，不存在则创建
		if (!ossClient.doesObjectExist(bucketName, keySuffixWithSlash)) {
			// 创建文件夹
			ossClient.putObject(bucketName, keySuffixWithSlash, new ByteArrayInputStream(new byte[0]));
			log.info("创建文件夹成功");
			// 得到文件夹名
			OSSObject object = ossClient.getObject(bucketName, keySuffixWithSlash);
			String fileDir = object.getKey();
			return fileDir;
		}
		return keySuffixWithSlash;
	}

}
