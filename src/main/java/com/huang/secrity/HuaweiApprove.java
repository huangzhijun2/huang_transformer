package com.huang.secrity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.security.UserGroupInformation;

import java.io.File;
import java.io.IOException;

/*@Component
 @Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)*/
public class HuaweiApprove {

	private final static Log log = LogFactory.getLog(HuaweiApprove.class);

	private static String PRINCIPAL = "username.client.kerberos.principal";
	private static String KEYTAB = "username.client.keytab.file";

	private static String principal = "LifeCheck";
	private static String confDirPath = File.separator+"cpic"+File.separator+"bigdata"+File.separator+"conf"+File.separator+"huang"+File.separator;
    
	private static String jaasPath = confDirPath + "jaas.conf";
	private static String userKeytabPath = confDirPath + "user.keytab";
	private static String krb5ConfPath = confDirPath + "krb5.conf";
	

	public static Configuration login() {
		
		Configuration conf = null;

		log.info("认证的用户是：" + principal);
		log.info("认证文件存放目录是：" + confDirPath);

		conf = new Configuration();
		conf.addResource(new Path(confDirPath + "core-site.xml"));//必须
		conf.addResource(new Path(confDirPath + "hbase-site.xml"));
		conf.addResource(new Path(confDirPath + "hdfs-site.xml"));//必须
		conf.addResource(new Path(confDirPath + "yarn-site.xml"));
		conf.addResource(new Path(confDirPath + "mapred-site.xml"));

		if (conf != null) {
			log.info("加载华为安全认证文件");
			System.setProperty("java.security.auth.login.config", jaasPath);
			System.setProperty("zookeeper.server.principal", principal);
			System.setProperty("java.security.krb5.conf", krb5ConfPath);
			conf.set(KEYTAB, userKeytabPath);
			conf.set(PRINCIPAL, principal);
			log.info("==================华为安全认证文件加载完成==================");
			
			try {
				log.info("====================华为安全认证中==================");
				UserGroupInformation.setConfiguration(conf);
				UserGroupInformation.loginUserFromKeytab(conf.get(PRINCIPAL),conf.get(KEYTAB));
				log.info("==================华为安全认证通过==================");
			} catch (IOException e) {
				log.error(e.getMessage());
			}
			
		}
		return conf;
	}

	public static Configuration getConfig() {
		Configuration conf = null;
		try {
			conf = login();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return conf;
	}
}
