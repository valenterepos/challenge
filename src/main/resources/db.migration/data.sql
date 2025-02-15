INSERT INTO specialty (name) VALUES
                                   ('DERMATOLOGY'),
                                   ('OPHTHALMOLOGY'),
                                   ('RADIOLOGY'),
                                   ('FAMILY_MEDICINE'),
                                   ('PEDIATRICS');


INSERT INTO doctor (name, specialty) VALUES
                                          ('António', 'Dermatology'),
                                          ('Maria', 'Ophthalmology'),
                                          ('Carlos', 'Radiology'),
                                          ('Gabriela', 'Family Medicine'),
                                          ('Paulo', 'Pediatrics');


INSERT INTO patient (name, age) VALUES
                                     ('Manuel', 53),
                                     ('Joana', 32),
                                     ('Ana', 25),
                                     ('Diogo', 33),
                                     ('Catarina', 33),
                                     ('Miguel', 40);


INSERT INTO pathology (name) VALUES
                                   ('Pathology 1'),
                                   ('Pathology 2'),
                                   ('Pathology 3'),
                                   ('Pathology 4');


INSERT INTO symptom (description) VALUES
                                       ('Symptom 1'),
                                       ('Symptom 2'),
                                       ('Symptom 3'),
                                       ('Symptom 4');


INSERT INTO patient_pathology (patient_id, pathology_id) VALUES
                                                             (1, 1), (1, 2),
                                                             (2, 3), (3, 4),
                                                             (4, 1), (5, 2),
                                                             (6, 3);


INSERT INTO pathology_symptom (pathology_id, symptom_id) VALUES
                                                             (1, 1), (1, 2),
                                                             (2, 3), (3, 1),
                                                             (4, 2), (4, 3);


INSERT INTO consult (doctor_id, patient_id) VALUES
                                                 (1, 1),
                                                 (2, 2),
                                                 (3, 3),
                                                 (4, 4),
                                                 (5, 5);