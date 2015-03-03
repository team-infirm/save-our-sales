package com.sagepay.sos;

import com.sagepay.sos.db.CancellationsDAO;
import com.sagepay.sos.health.BasicHealthCheck;
import com.sagepay.sos.resources.CancellationResource;
import com.sagepay.sos.resources.CancellationsResource;
import com.sagepay.sos.resources.ChaserResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class TransactionApplication extends Application<TransactionApplicationConfiguration> {
    @Override
    public void initialize(Bootstrap<TransactionApplicationConfiguration> bootstrap) {

    }

    public static void main(String[] args) throws Exception {
        new TransactionApplication().run(args);
    }

    @Override
    public void run(TransactionApplicationConfiguration transactionApplicationConfiguration, Environment environment) throws Exception {
        environment.healthChecks().register("Blank Health Check", new BasicHealthCheck());
        CancellationsDAO cancellationsDAO = new CancellationsDAO();
        environment.jersey().register(new ChaserResource());
        environment.jersey().register(new CancellationResource(cancellationsDAO));
        environment.jersey().register(new CancellationsResource(cancellationsDAO));
    }
}
