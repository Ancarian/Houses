package dev.chermenin.api.configuration;


import dev.chermenin.api.rest.*;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.config.SwaggerConfigLocator;
import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.models.Swagger;
import io.swagger.models.auth.ApiKeyAuthDefinition;
import io.swagger.models.auth.In;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletConfigAware;

import javax.servlet.ServletConfig;
import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath(value = "/api")
public class JerseyConfiguration extends ResourceConfig implements ServletConfigAware {
    private ServletConfig servletConfig;

    public JerseyConfiguration() {
        registerEndpoints();
        configureSwagger();
    }

    private void registerEndpoints() {
        register(new CorsFilter());
        register(UserController.class);
        register(CountryController.class);
        register(CityController.class);
        register(StateController.class);
        register(PostController.class);
        //register(GlobalExceptionHandler.class);
    }

    private void configureSwagger() {
        BeanConfig swaggerConfig = new BeanConfig();
        swaggerConfig.setBasePath("/api");
        SwaggerConfigLocator.getInstance().putConfig(SwaggerContextService.CONFIG_ID_DEFAULT, swaggerConfig);
        packages(getClass().getPackage().getName(),
                ApiListingResource.class.getPackage().getName());

        Swagger swagger = new Swagger();
        swagger.securityDefinition("oauth", new ApiKeyAuthDefinition("Authorization", In.HEADER));
        new SwaggerContextService().withServletConfig(servletConfig).updateSwagger(swagger);
    }

    @Override
    public void setServletConfig(ServletConfig servletConfig) {
        this.servletConfig = servletConfig;
    }
}
