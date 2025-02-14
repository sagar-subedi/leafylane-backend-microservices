
INSERT INTO USER (USER_ID, FIRST_NAME, LAST_NAME, PASSWORD, USER_NAME, EMAIL)  VALUES
('asdasdsa-6727-4229-a4ab-zxczxcxczxcc', 'Subedi', 'Saagar', '$2a$10$2XWkMz42.EApOBnx7nJaSupInwvBfPCGb5HZwWM.2RsC92joeAQzq', 'sagar.subedi', 'john.doe@gmail.com'),
('xcvcvbvv-ba5d-4b92-85be-dfgdfgdfgdfg', 'Admin', 'Admin', '$2a$10$br7HrUzeQQ0ddR2ogg7L1.aRQ1sGC1rud.mL8VQBEKaMkx1G5zXR6', 'admin.admin', 'admin@gmail.com'),
('rertertr-6727-4229-a4ab-erererererer', 'Subedi', 'Saagar', '$2a$10$2XWkMz42.EApOBnx7nJaSupInwvBfPCGb5HZwWM.2RsC92joeAQzq', 'sagarsubedi01', 'sagarsubedi01@gmail.com'),
('cvcvbcvb-ba5d-4b92-85be-fggfgtrytyty', 'Admin', 'Admin', '$2a$10$br7HrUzeQQ0ddR2ogg7L1.aRQ1sGC1rud.mL8VQBEKaMkx1G5zXR6', 'subedi.coder', 'subedi.coder@gmail.com'),
('cvbserte-6727-4229-a4ab-vbnbvvnvbnvb', 'Subedi', 'Saagar', '$2a$10$2XWkMz42.EApOBnx7nJaSupInwvBfPCGb5HZwWM.2RsC92joeAQzq', 'pokhreli.subedi', 'pokhreli.subedi@gmail.com'),
('xcvxvcgv-ba5d-4b92-85be-fghfghtryfgh', 'Admin', 'Admin', '$2a$10$br7HrUzeQQ0ddR2ogg7L1.aRQ1sGC1rud.mL8VQBEKaMkx1G5zXR6', 'sagar.pokhara', 'sagar.pokhara@gmail.com'),
('ddfgdfgh-6727-4229-a4ab-ertdfgfdgdfg', 'Subedi', 'Saagar', '$2a$10$2XWkMz42.EApOBnx7nJaSupInwvBfPCGb5HZwWM.2RsC92joeAQzq', 'subedi.pokhara', 'subedi.pokhara@gmail.com'),
('dfgdfgdf-ba5d-4b92-85be-vbvbvbnvbnjb', 'Admin', 'Admin', '$2a$10$br7HrUzeQQ0ddR2ogg7L1.aRQ1sGC1rud.mL8VQBEKaMkx1G5zXR6', 'sagar.bro', 'sagar.bro@gmail.com');

INSERT INTO ROLE (ROLE_ID, ROLE_NAME, ROLE_DESCRIPTION) VALUES ('9601409f-4691-4281-886e-8f8987763b56', 'STANDARD_USER', 'Standard User - Has no admin rights');
INSERT INTO ROLE (ROLE_ID, ROLE_NAME, ROLE_DESCRIPTION) VALUES ('f4b194d0-238b-41b5-8f18-630e5fcf3d8e', 'ROLE_ADMIN', 'Admin User - Has permission to perform admin tasks');
INSERT INTO ROLE (ROLE_ID, ROLE_NAME, ROLE_DESCRIPTION) VALUES ('erwerwer-erer-erfd-8f18-cvbdfgdgfggg', 'SELLER', 'Seller who can manage his inventory');
INSERT INTO ROLE (ROLE_ID, ROLE_NAME, ROLE_DESCRIPTION) VALUES ('tytryyrt-rtyr-rtyr-rtyr-fghfghfggfhg', 'PRODUCT_OWNER', 'Product Owner');

INSERT INTO USER_ROLES(USER_ID, ROLE_ID) VALUES('asdasdsa-6727-4229-a4ab-zxczxcxczxcc','9601409f-4691-4281-886e-8f8987763b56');
INSERT INTO USER_ROLES(USER_ID, ROLE_ID) VALUES('xcvcvbvv-ba5d-4b92-85be-dfgdfgdfgdfg','9601409f-4691-4281-886e-8f8987763b56');
INSERT INTO USER_ROLES(USER_ID, ROLE_ID) VALUES('xcvcvbvv-ba5d-4b92-85be-dfgdfgdfgdfg','f4b194d0-238b-41b5-8f18-630e5fcf3d8e');
INSERT INTO USER_ROLES(USER_ID, ROLE_ID) VALUES('rertertr-6727-4229-a4ab-erererererer','9601409f-4691-4281-886e-8f8987763b56');
INSERT INTO USER_ROLES(USER_ID, ROLE_ID) VALUES('dfgdfgdf-ba5d-4b92-85be-vbvbvbnvbnjb','tytryyrt-rtyr-rtyr-rtyr-fghfghfggfhg');

INSERT INTO oauth2_client_details (CLIENT_ID, CLIENT_SECRET, SCOPE, AUTHORIZED_GRANT_TYPES, WEB_SERVER_REDIRECT_URI, AUTHORITIES, ACCESS_TOKEN_VALIDITY, REFRESH_TOKEN_VALIDITY, ADDITIONAL_INFORMATION, AUTOAPPROVE, RESOURCE_IDS) VALUES  ('93ed453e-b7ac-4192-a6d4-c45fae0d99ac','$2a$10$LulvWhcpUv8lFGmd9NbIG.PB46E5/tcivjGbELWMMWeBuDHKtrVKa', 'read,write',  'password,authorization_code,refresh_token,client_credentials', 'http://localhost:5678', 'ROLE_ADMIN', 259200, 604800, null, true,'web');
