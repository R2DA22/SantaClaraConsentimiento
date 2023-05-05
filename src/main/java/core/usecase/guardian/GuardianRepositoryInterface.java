package core.usecase.guardian;

import core.domain.patient.Guardian;

public interface GuardianRepositoryInterface {

     Guardian find(Integer idType, String id) throws Exception;
     void create(Guardian Guardian) throws Exception ;
     void update(Guardian Guardian) throws Exception ;


}
