package com.apulia.businesscomponent.codgenerator;

import java.io.IOException;
import com.apulia.architecture.dao.DAOException;

public interface CodGeneratorInterface {
	long getNextCod() throws ClassNotFoundException, DAOException, IOException;
}
