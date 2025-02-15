CREATE TABLE specialties (
                             id BIGSERIAL PRIMARY KEY,
                             name VARCHAR(255) UNIQUE NOT NULL
);


CREATE TABLE doctors (
                         id BIGSERIAL PRIMARY KEY,
                         name VARCHAR(255) UNIQUE NOT NULL,
                         specialty VARCHAR(50) NOT NULL
);


CREATE TABLE patients (
                          id BIGSERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          age INT NOT NULL
);


CREATE TABLE consults (
                          id BIGSERIAL PRIMARY KEY,
                          doctor_id BIGINT NOT NULL REFERENCES doctors(id),
                          patient_id BIGINT NOT NULL REFERENCES patients(id)
);


CREATE TABLE pathologies (
                             id BIGSERIAL PRIMARY KEY,
                             name VARCHAR(255) NOT NULL
);


CREATE TABLE patient_pathologies (
                                     patient_id BIGINT NOT NULL REFERENCES patients(id),
                                     pathology_id BIGINT NOT NULL REFERENCES pathologies(id),
                                     PRIMARY KEY (patient_id, pathology_id)
);


CREATE TABLE symptoms (
                          id BIGSERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          description TEXT NOT NULL
);


CREATE TABLE pathology_symptoms (
                                    pathology_id BIGINT NOT NULL REFERENCES pathologies(id),
                                    symptom_id BIGINT NOT NULL REFERENCES symptoms(id),
                                    PRIMARY KEY (pathology_id, symptom_id)
);


INSERT INTO specialties (name) VALUES
                                   ('DERMATOLOGY'),
                                   ('OPHTHALMOLOGY'),
                                   ('RADIOLOGY'),
                                   ('FAMILY_MEDICINE'),
                                   ('PEDIATRICS');


INSERT INTO doctors (name, specialty) VALUES
                                          ('António', 'DERMATOLOGY'),
                                          ('Maria', 'OPHTHALMOLOGY'),
                                          ('Carlos', 'RADIOLOGY'),
                                          ('Gabriela', 'FAMILY_MEDICINE'),
                                          ('Paulo', 'PEDIATRICS');


INSERT INTO patients (name, age) VALUES
                                     ('Manuel', 53),
                                     ('Joana', 32),
                                     ('Ana', 25),
                                     ('Diogo', 33),
                                     ('Catarina', 33),
                                     ('Miguel', 40);


INSERT INTO consults (doctor_id, patient_id) VALUES
                                                 (1, 1),
                                                 (1, 1),
                                                 (2, 1),
                                                 (2, 2),
                                                 (3, 3),
                                                 (4, 4),
                                                 (5, 5),
                                                 (2, 6);


INSERT INTO pathologies (name) VALUES
                                   ('Pathology 1'),
                                   ('Pathology 2'),
                                   ('Pathology 3'),
                                   ('Pathology 4'),
                                   ('Pathology 5'),
                                   ('Pathology 6'),
                                   ('Pathology 7');


INSERT INTO patient_pathologies (patient_id, pathology_id) VALUES
                                                               (1, 1), (1, 2),
                                                               (2, 3), (3, 4),
                                                               (4, 1), (5, 2),
                                                               (6, 3);

INSERT INTO symptoms (name, description) VALUES
                                             ('Symptom 1', 'Description for symptom 1'),
                                             ('Symptom 2', 'Description for symptom 2'),
                                             ('Symptom 3', 'Description for symptom 3'),
                                             ('Symptom 4', 'Description for symptom 4'),
                                             ('Symptom 5', 'Description for symptom 5'),
                                             ('Symptom 6', 'Description for symptom 6'),
                                             ('Symptom 7', 'Description for symptom 7'),
                                             ('Symptom 8', 'Description for symptom 8'),
                                             ('Symptom 9', 'Description for symptom 9'),
                                             ('Symptom 10', 'Description for symptom 10'),
                                             ('Symptom 11', 'Description for symptom 11'),
                                             ('Symptom 12', 'Description for symptom 12'),
                                             ('Symptom 13', 'Description for symptom 13'),
                                             ('Symptom 14', 'Description for symptom 14'),
                                             ('Symptom 15', 'Description for symptom 15');

INSERT INTO pathology_symptoms (pathology_id, symptom_id) VALUES
                                                              (1, 1), (1, 2),
                                                              (2, 3), (2, 4),
                                                              (3, 5), (3, 6),
                                                              (4, 7), (4, 8),
                                                              (5, 9), (5, 10),
                                                              (6, 11), (6, 12),
                                                              (7, 13), (7, 14),
                                                              (7, 15);
