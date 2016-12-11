package demo.client.simple;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.stereotype.Component;

/**
 * Why I need to do this?
 * WTF using ConfigurationProperties???
 */
@Component("details")
@ConfigurationProperties("security.oauth2.client")
public class ClientCredentialsDetails extends ClientCredentialsResourceDetails {
}
