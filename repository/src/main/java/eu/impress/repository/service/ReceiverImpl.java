package eu.impress.repository.service;

import eu.impress.logevo.util.PatevoCall;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;

@Component
public class ReceiverImpl {
	@Autowired
	PatevoCall patevoCall;
	@Autowired
	private ApplicationContext ctx;

	@JmsListener(destination = "IMPRESS.IncidentMgmt.TrackingPatients", containerFactory = "alertJmsContainerFactory", subscription = "intl-89824")
	public void receiveMessage(String message) {
		patevoCall.patevoLoop(message);

		FileSystemUtils.deleteRecursively(new File("activemq-data"));
	}

}
