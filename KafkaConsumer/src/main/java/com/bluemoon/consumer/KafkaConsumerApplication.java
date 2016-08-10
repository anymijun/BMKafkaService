package com.bluemoon.consumer;



import com.bluemoon.consumer.bean.KafkaMessageConsumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableScheduling;


@Configuration
@EnableAutoConfiguration
@EnableScheduling
@ComponentScan
public class KafkaConsumerApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(KafkaConsumerApplication.class, args);



		KafkaMessageConsumer.getInstance().call();




	}

//	@Profile("ssl")
//	@Bean
//	EmbeddedServletContainerCustomizer containerCustomizer(@Value("${keystore.file}") Resource keystoreFile,
//														   @Value("${keystore.pass}") String keystorePass)
//			throws Exception {
//		String absoluteKeystoreFile = keystoreFile.getFile().getAbsolutePath();
//		return (ConfigurableEmbeddedServletContainer container) -> {
//			if (container instanceof TomcatEmbeddedServletContainerFactory) {
//				TomcatEmbeddedServletContainerFactory tomcat = (TomcatEmbeddedServletContainerFactory) container;
//
//				tomcat.addConnectorCustomizers(
//						(connector) -> {
//							connector.setPort(8443);
//							connector.setSecure(true);
//							connector.setScheme("https");
//							Http11NioProtocol proto = (Http11NioProtocol) connector.getProtocolHandler();
//							proto.setSSLEnabled(true);
//							proto.setKeystoreFile(absoluteKeystoreFile);
//							proto.setKeystorePass(keystorePass);
//							proto.setKeystoreType("PKCS12");
//							proto.setKeyAlias("tomcat");
//						}/*,
//                        (connector) -> {
//                            connector.setPort(80);
//                            connector.setSecure(false);
//                            connector.setEnableLookups(false);
//                            connector.setRedirectPort(443);
//                            connector.setScheme("http");
//                            Http11NioProtocol proto = (Http11NioProtocol) connector.getProtocolHandler();
//                            proto.setSSLEnabled(false);
//                        }*/
//				);
//			}
//		};
//	}
}
