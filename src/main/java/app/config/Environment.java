package app.config;

import core.domain.area.Area;
import core.domain.configuration.Configuration;
import core.domain.consent.CovidConsent;
import core.domain.consent.DentalConsent;
import core.domain.consent.DentalCovidConsent;
import core.domain.consent.EmergencyConsent;
import core.domain.consent.IdConsent;
import core.domain.consent.ProcessConsent;
import core.domain.patient.DocumentType;
import core.domain.patient.Guardian;
import core.domain.patient.Patient;
import core.domain.process.Process;
import core.domain.professional.Professional;
import core.domain.speciality.Speciality;
import core.domain.vaccine.Vaccine;
import core.usecase.area.find.FindAllAreaUseCase;
import core.usecase.configurations.find.FindConfigurationUseCase;
import core.usecase.consent.create.CreateCovidConsentUseCase;
import core.usecase.consent.create.CreateDentalConsentUseCase;
import core.usecase.consent.create.CreateDentalCovidConsentUseCase;
import core.usecase.consent.create.CreateEmergencyConsentUseCase;
import core.usecase.consent.create.CreateProcessConsentUseCase;
import core.usecase.consent.find.FindNextIdConsentUseCase;
import core.usecase.document.findAll.FindAllDocumentTypesUseCase;
import core.usecase.guardian.create.CreateGuardianUseCase;
import core.usecase.guardian.find.FindGuardianUseCase;
import core.usecase.patient.find.FindPatientUseCase;
import core.usecase.patient.create.CreatePatientUseCase;
import core.usecase.process.create.CreateProcessUseCase;
import core.usecase.process.find.FindAllProcessByAreaUseCase;
import core.usecase.professional.create.CreateProfessionalUseCase;
import core.usecase.professional.find.FindProfessionalUseCase;
import core.usecase.speciality.find.FindSpecialityUsesCase;
import core.usecase.vaccine.find.FindAllVaccineUseCase;
import infrastructure.bus.command.CommandSyncBus;
import infrastructure.bus.query.QuerySyncBus;
import infrastructure.controllers.Controller;
import infrastructure.handlers.area.FindAllAreaHandler;
import infrastructure.handlers.configuration.FindConfigurationHandler;
import infrastructure.handlers.consent.CreateCovidConsentHandler;
import infrastructure.handlers.consent.CreateDentalConsentHandler;
import infrastructure.handlers.consent.CreateDentalCovidConsentHandler;
import infrastructure.handlers.consent.CreateEmergencyConsentHandler;
import infrastructure.handlers.consent.CreateProcessConsentHandler;
import infrastructure.handlers.consent.FindNextIdHandler;
import infrastructure.handlers.document.FindAllTypeDocumentHandler;
import infrastructure.handlers.guardian.CreateGuardianHandler;
import infrastructure.handlers.guardian.FindGuardianHandler;
import infrastructure.handlers.patient.CreatePatientHandler;
import infrastructure.handlers.patient.FindPatientHandler;
import infrastructure.handlers.process.CreateProcessHandler;
import infrastructure.handlers.process.FindAllProcessHandler;
import infrastructure.handlers.professional.CreateProfessionalHandler;
import infrastructure.handlers.professional.FindProfessionalHandler;
import infrastructure.handlers.speciality.FindAllSpecialityHandler;
import infrastructure.handlers.vaccine.FindAllVaccineHandler;
import infrastructure.platform.postgresql.Postgresql;
import infrastructure.repository.area.AreaMapper;
import infrastructure.repository.area.AreaRepository;
import infrastructure.repository.configuration.ConfigurationMapper;
import infrastructure.repository.configuration.ConfigurationRepository;
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


public class Environment {

    private final Postgresql db;
    private final Controller controller;

    public Environment() throws Exception {
        db = new Postgresql();

        DocumentRepository documentRepository = new DocumentRepository(db, new DocumentMapper());
        PatientRepository patientRepository = new PatientRepository(db, new PatientMapper());
        GuardianRepository guardianRepository = new GuardianRepository(db, new GuardianMapper());
        ConsentRepository consentRepository = new ConsentRepository(db);
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
        FindAllProcessByAreaUseCase findAllProcessByAreaUseCase = new FindAllProcessByAreaUseCase(processRepository);
        FindAllAreaUseCase findAllAreaUseCase = new FindAllAreaUseCase(areaRepository);

        CreateDentalConsentUseCase createDentalConsentUseCase = new CreateDentalConsentUseCase(consentRepository, processRepository);
        CreateDentalCovidConsentUseCase createDentalCovidConsentUseCase = new CreateDentalCovidConsentUseCase(consentRepository);
        CreateEmergencyConsentUseCase createEmergencyConsentUseCase = new CreateEmergencyConsentUseCase(consentRepository);
        CreateCovidConsentUseCase createCovidConsentUseCase = new CreateCovidConsentUseCase(consentRepository);
        CreateProcessConsentUseCase createProcessConsentUseCase = new CreateProcessConsentUseCase(consentRepository);
        CreatePatientUseCase createPatientUseCase = new CreatePatientUseCase(patientRepository);
        CreateGuardianUseCase createGuardianUseCase = new CreateGuardianUseCase(guardianRepository);
        CreateProfessionalUseCase createProfessionalUseCase = new CreateProfessionalUseCase(professionalRepository);
        CreateProcessUseCase createProcessUseCase = new CreateProcessUseCase(processRepository);

        CreateDentalConsentHandler createDentalConsentHandler = new CreateDentalConsentHandler(createDentalConsentUseCase);
        CreateDentalCovidConsentHandler createDentalCovidConsentHandler = new CreateDentalCovidConsentHandler(createDentalCovidConsentUseCase);
        CreateEmergencyConsentHandler createEmergencyConsentHandler = new CreateEmergencyConsentHandler(createEmergencyConsentUseCase);
        CreateProcessConsentHandler createProcessConsentHandler = new CreateProcessConsentHandler(createProcessConsentUseCase);
        CreateCovidConsentHandler createCovidConsentHandler = new CreateCovidConsentHandler(createCovidConsentUseCase);
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
        FindAllAreaHandler findAllAreaHandler = new FindAllAreaHandler(findAllAreaUseCase);
        FindAllProcessHandler findAllProcessHandler = new FindAllProcessHandler(findAllProcessByAreaUseCase);

        CommandSyncBus commandBus = new CommandSyncBus();
        QuerySyncBus queryBus = new QuerySyncBus();

        commandBus.register(DentalCovidConsent.class.getName(), createDentalCovidConsentHandler);
        commandBus.register(DentalConsent.class.getName(), createDentalConsentHandler);
        commandBus.register(EmergencyConsent.class.getName(), createEmergencyConsentHandler);
        commandBus.register(CovidConsent.class.getName(), createCovidConsentHandler);
        commandBus.register(ProcessConsent.class.getName(), createProcessConsentHandler);
        commandBus.register(Patient.class.getName(), createPatientHandler);
        commandBus.register(Guardian.class.getName(), createGuardianHandler);
        commandBus.register(Professional.class.getName(), createProfessionalHandler);
        commandBus.register(Process.class.getName(), createProcessHandler);

        queryBus.register(Process.class.getName(), findAllProcessHandler);
        queryBus.register(Area.class.getName(), findAllAreaHandler);
        queryBus.register(Vaccine.class.getName(), findAllVaccineHandler);
        queryBus.register(Speciality.class.getName(), findAllSpecialityHandler);
        queryBus.register(Professional.class.getName(), findProfessionalHandler);
        queryBus.register(Guardian.class.getName(), findGuardianHandler);
        queryBus.register(Patient.class.getName(), findPatientHandler);
        queryBus.register(IdConsent.class.getName(), findNextIdHandler);
        queryBus.register(DocumentType.class.getName(), findAllTypeDocumentHandler);
        queryBus.register(Configuration.class.getName(), findConfigurationHandler);

        controller = new Controller(commandBus, queryBus);
    }

    public Controller getController() {
        return controller;
    }
}
