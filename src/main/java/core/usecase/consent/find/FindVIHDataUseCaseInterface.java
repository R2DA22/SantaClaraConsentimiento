package core.usecase.consent.find;

import core.domain.consent.VIHData;
import infrastructure.repository.consent.ConsentVIHDTO;

public interface FindVIHDataUseCaseInterface {
        ConsentVIHDTO execute(VIHData filter) throws Exception;
}
