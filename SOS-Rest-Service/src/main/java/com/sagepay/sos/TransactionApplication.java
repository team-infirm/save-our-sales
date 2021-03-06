package com.sagepay.sos;

import com.sagepay.sos.db.CancellationsDAO;
import com.sagepay.sos.db.MapCancellationsDAO;
import com.sagepay.sos.health.BasicHealthCheck;
import com.sagepay.sos.resources.CancellationsResource;
import com.sagepay.sos.resources.ChaserResource;
import com.sagepay.sos.resources.TransactionFailureEndpoint;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class TransactionApplication extends Application<TransactionApplicationConfiguration> {
    @Override
    public void initialize(Bootstrap<TransactionApplicationConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/assets", "/", "cancellation.html"));
    }

    public static void main(String[] args) throws Exception {
        new TransactionApplication().run(args);
    }

    @Override
    public void run(TransactionApplicationConfiguration transactionApplicationConfiguration, Environment environment) throws Exception {
        environment.healthChecks().register("Blank Health Check", new BasicHealthCheck());
        CancellationsDAO cancellationsDAO = new MapCancellationsDAO();
        environment.jersey().register(new ChaserResource(cancellationsDAO));
        environment.jersey().register(new CancellationsResource(cancellationsDAO));
        environment.jersey().register(new TransactionFailureEndpoint(cancellationsDAO));
        environment.jersey().setUrlPattern("/api/*");
    }
}
