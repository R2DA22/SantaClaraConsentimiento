package app.config;

import core.domain.area.Area;
import core.domain.consent.ConsentVIH;
import core.domain.consent.IdConsent;
import core.domain.consent.VIHData;
import core.domain.patient.DocumentType;
import core.domain.patient.Guardian;
import core.domain.patient.Patient;
import core.domain.process.Process;
import core.domain.professional.Professional;
import core.domain.professional.ProfessionalList;
import core.domain.speciality.Speciality;
import core.domain.vaccine.Vaccine;
import core.usecase.area.find.FindAllAreaUseCase;
import core.usecase.configurations.find.FindConfigurationUseCase;
import core.usecase.consent.create.CreateVIHUseCase;
import core.usecase.consent.find.FindNextIdConsentUseCase;
import core.usecase.consent.find.FindVIHUseCase;
import core.usecase.document.findAll.FindAllDocumentTypesUseCase;
import core.usecase.guardian.create.CreateGuardianUseCase;
import core.usecase.guardian.find.FindGuardianUseCase;
import core.usecase.patient.find.FindPatientUseCase;
import core.usecase.patient.create.CreatePatientUseCase;
import core.usecase.process.create.CreateProcessUseCase;
import core.usecase.process.find.FindAllProcessByAreaUseCase;
import core.usecase.professional.create.CreateProfessionalUseCase;
import core.usecase.professional.find.FindAllProfessionalUseCase;
import core.usecase.professional.find.FindProfessionalUseCase;
import core.usecase.speciality.find.FindSpecialityUsesCase;
import core.usecase.vaccine.find.FindAllVaccineUseCase;
import infrastructure.bus.command.CommandSyncBus;
import infrastructure.bus.query.QuerySyncBus;
import infrastructure.controllers.Controller;
import infrastructure.handlers.area.FindAllAreaHandler;
import infrastructure.handlers.configuration.FindConfigurationHandler;
import infrastructure.handlers.consent.CreateVIHConsentHandler;
import infrastructure.handlers.consent.FindNextIdHandler;
import infrastructure.handlers.consent.FindVIHDataHandler;
import infrastructure.handlers.document.FindAllTypeDocumentHandler;
import infrastructure.handlers.guardian.CreateGuardianHandler;
import infrastructure.handlers.guardian.FindGuardianHandler;
import infrastructure.handlers.patient.CreatePatientHandler;
import infrastructure.handlers.patient.FindPatientHandler;
import infrastructure.handlers.process.CreateProcessHandler;
import infrastructure.handlers.process.FindAllProcessHandler;
import infrastructure.handlers.professional.CreateProfessionalHandler;
import infrastructure.handlers.professional.FindAllProfessionalHandler;
import infrastructure.handlers.professional.FindProfessionalHandler;
import infrastructure.handlers.speciality.FindAllSpecialityHandler;
import infrastructure.handlers.vaccine.FindAllVaccineHandler;
import infrastructure.platform.postgresql.Postgresql;
import infrastructure.repository.area.AreaMapper;
import infrastructure.repository.area.AreaRepository;
import infrastructure.repository.configuration.ConfigurationMapper;
import infrastructure.repository.configuration.ConfigurationRepository;
import infrastructure.repository.consent.ConsentMapper;
import infrastructure.repository.consent.ConsentRepository;
import infrastructure.repository.document.DocumentMapper;
import infrastructure.repository.document.DocumentRepository;
import infrastructure.repository.guardian.GuardianMapper;
import infrastructure.repository.guardian.GuardianRepository;
import infrastructure.repository.patient.PatientMapper;
import infrastructure.repository.patient.PatientRepository;
import infrastructure.repository.process.ProcessMapper;
import infrastructure.repository.process.ProcessRepository;
import infrastructure.repository.professional.ProfessionalMapper;
import infrastructure.repository.professional.ProfessionalRepository;
import infrastructure.repository.speciality.SpecialityMapper;
import infrastructure.repository.speciality.SpecialityRepository;
import infrastructure.repository.vaccine.VaccineMapper;
import infrastructure.repository.vaccine.VaccineRepository;
import java.util.Properties;


public class Environment {

    private final Configuration configuration;
    private final Controller controller;

    public Environment() throws Exception {
        configuration = Configuration.getInstance();
        Properties properties = configuration.getProperties();
        Postgresql db = new Postgresql(properties);

        DocumentRepository documentRepository = new DocumentRepository(db, new DocumentMapper());
        PatientRepository patientRepository = new PatientRepository(db, new PatientMapper());
        GuardianRepository guardianRepository = new GuardianRepository(db, new GuardianMapper());
        ConsentRepository consentRepository = new ConsentRepository(db, new ConsentMapper());
        ConfigurationRepository configurationRepository = new ConfigurationRepository(db, new ConfigurationMapper());
        SpecialityRepository specialityRepository = new SpecialityRepository(db, new SpecialityMapper());
        VaccineRepository vaccineRepository = new VaccineRepository(db, new VaccineMapper());
        AreaRepository areaRepository = new AreaRepository(db, new AreaMapper());
        ProcessRepository processRepository = new ProcessRepository(db, new ProcessMapper());
        ProfessionalRepository professionalRepository = new ProfessionalRepository(db, new ProfessionalMapper());

        FindAllDocumentTypesUseCase findAllDocumentsTypeUseCase = new FindAllDocumentTypesUseCase(documentRepository);
        FindNextIdConsentUseCase findNextIdConsentUseCase = new FindNextIdConsentUseCase(consentRepository);
        FindPatientUseCase findPatientUseCase = new FindPatientUseCase(patientRepository);
        FindGuardianUseCase findGuardianUseCase = new FindGuardianUseCase(guardianRepository);
        FindConfigurationUseCase findConfigurationUseCase = new FindConfigurationUseCase(configurationRepository);
        FindSpecialityUsesCase findSpecialityUsesCase = new FindSpecialityUsesCase(specialityRepository);
        FindAllVaccineUseCase findAllVaccineUseCase = new FindAllVaccineUseCase(vaccineRepository);
        FindProfessionalUseCase findProfessionalUseCase = new FindProfessionalUseCase(professionalRepository);
        FindAllProfessionalUseCase findAllProfessionalUseCase = new FindAllProfessionalUseCase(professionalRepository);
        FindAllProcessByAreaUseCase findAllProcessByAreaUseCase = new FindAllProcessByAreaUseCase(processRepository);
        FindAllAreaUseCase findAllAreaUseCase = new FindAllAreaUseCase(areaRepository);
        FindVIHUseCase findVIHUseCase = new FindVIHUseCase(consentRepository);

        CreateVIHUseCase createVIHUseCase = new CreateVIHUseCase(consentRepository);
        CreatePatientUseCase createPatientUseCase = new CreatePatientUseCase(patientRepository);
        CreateGuardianUseCase createGuardianUseCase = new CreateGuardianUseCase(guardianRepository);
        CreateProfessionalUseCase createProfessionalUseCase = new CreateProfessionalUseCase(professionalRepository);
        CreateProcessUseCase createProcessUseCase = new CreateProcessUseCase(processRepository);


        CreateVIHConsentHandler createVIHConsentHandler = new CreateVIHConsentHandler(createVIHUseCase);
        CreatePatientHandler createPatientHandler = new CreatePatientHandler(createPatientUseCase);
        CreateGuardianHandler createGuardianHandler = new CreateGuardianHandler(createGuardianUseCase);
        CreateProcessHandler createProcessHandler = new CreateProcessHandler(createProcessUseCase);
        CreateProfessionalHandler createProfessionalHandler = new CreateProfessionalHandler(createProfessionalUseCase);

        FindGuardianHandler findGuardianHandler = new FindGuardianHandler(findGuardianUseCase);
        FindPatientHandler findPatientHandler = new FindPatientHandler(findPatientUseCase);
        FindNextIdHandler findNextIdHandler = new FindNextIdHandler(findNextIdConsentUseCase);
        FindAllTypeDocumentHandler findAllTypeDocumentHandler = new FindAllTypeDocumentHandler(findAllDocumentsTypeUseCase);
        FindConfigurationHandler findConfigurationHandler = new FindConfigurationHandler(findConfigurationUseCase);
        FindAllSpecialityHandler findAllSpecialityHandler = new FindAllSpecialityHandler(findSpecialityUsesCase);
        FindAllVaccineHandler findAllVaccineHandler = new FindAllVaccineHandler(findAllVaccineUseCase);
        FindProfessionalHandler findProfessionalHandler = new FindProfessionalHandler(findProfessionalUseCase);
        FindAllProfessionalHandler findAllProfessionalHandler = new FindAllProfessionalHandler(findAllProfessionalUseCase);
        FindAllAreaHandler findAllAreaHandler = new FindAllAreaHandler(findAllAreaUseCase);
        FindAllProcessHandler findAllProcessHandler = new FindAllProcessHandler(findAllProcessByAreaUseCase);
        FindVIHDataHandler findVIHDataHandler = new FindVIHDataHandler(findVIHUseCase);

        CommandSyncBus commandBus = new CommandSyncBus();
        QuerySyncBus queryBus = new QuerySyncBus();

        commandBus.register(Patient.class.getName(), createPatientHandler);
        commandBus.register(Guardian.class.getName(), createGuardianHandler);
        commandBus.register(Professional.class.getName(), createProfessionalHandler);
        commandBus.register(Process.class.getName(), createProcessHandler);
        commandBus.register(ConsentVIH.class.getName(), createVIHConsentHandler);

        queryBus.register(Process.class.getName(), findAllProcessHandler);
        queryBus.register(Area.class.getName(), findAllAreaHandler);
        queryBus.register(Vaccine.class.getName(), findAllVaccineHandler);
        queryBus.register(Speciality.class.getName(), findAllSpecialityHandler);
        queryBus.register(Professional.class.getName(), findProfessionalHandler);
        queryBus.register(Guardian.class.getName(), findGuardianHandler);
        queryBus.register(Patient.class.getName(), findPatientHandler);
        queryBus.register(IdConsent.class.getName(), findNextIdHandler);
        queryBus.register(DocumentType.class.getName(), findAllTypeDocumentHandler);
        queryBus.register(core.domain.configuration.Configuration.class.getName(), findConfigurationHandler);
        queryBus.register(ProfessionalList.class.getName(), findAllProfessionalHandler);
        queryBus.register(VIHData.class.getName(), findVIHDataHandler);

        controller = new Controller(commandBus, queryBus);
    }

    public Controller getController() {
        return controller;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
