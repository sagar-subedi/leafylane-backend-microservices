--CREATE TABLE oauth2_authorization
--(
--    id                            varchar(100) NOT NULL,
--    registered_client_id          varchar(100) NOT NULL,
--    principal_name                varchar(200) NOT NULL,
--    authorization_grant_type      varchar(100) NOT NULL,
--    authorized_scopes             varchar(1000) DEFAULT NULL,
--    attributes                    blob          DEFAULT NULL,
--    state                         varchar(500)  DEFAULT NULL,
--    authorization_code_value      blob          DEFAULT NULL,
--    authorization_code_issued_at  timestamp     DEFAULT NULL,
--    authorization_code_expires_at timestamp     DEFAULT NULL,
--    authorization_code_metadata   blob          DEFAULT NULL,
--    access_token_value            blob          DEFAULT NULL,
--    access_token_issued_at        timestamp     DEFAULT NULL,
--    access_token_expires_at       timestamp     DEFAULT NULL,
--    access_token_metadata         blob          DEFAULT NULL,
--    access_token_type             varchar(100)  DEFAULT NULL,
--    access_token_scopes           varchar(1000) DEFAULT NULL,
--    oidc_id_token_value           blob          DEFAULT NULL,
--    oidc_id_token_issued_at       timestamp     DEFAULT NULL,
--    oidc_id_token_expires_at      timestamp     DEFAULT NULL,
--    oidc_id_token_metadata        blob          DEFAULT NULL,
--    refresh_token_value           blob          DEFAULT NULL,
--    refresh_token_issued_at       timestamp     DEFAULT NULL,
--    refresh_token_expires_at      timestamp     DEFAULT NULL,
--    refresh_token_metadata        blob          DEFAULT NULL,
--    user_code_value               blob          DEFAULT NULL,
--    user_code_issued_at           timestamp     DEFAULT NULL,
--    user_code_expires_at          timestamp     DEFAULT NULL,
--    user_code_metadata            blob          DEFAULT NULL,
--    device_code_value             blob          DEFAULT NULL,
--    device_code_issued_at         timestamp     DEFAULT NULL,
--    device_code_expires_at        timestamp     DEFAULT NULL,
--    device_code_metadata          blob          DEFAULT NULL,
--    PRIMARY KEY (id)
--);
--
--CREATE TABLE oauth2_authorization_consent
--(
--    registered_client_id varchar(100)  NOT NULL,
--    principal_name       varchar(200)  NOT NULL,
--    authorities          varchar(1000) NOT NULL,
--    PRIMARY KEY (registered_client_id, principal_name)
--);
--
--CREATE TABLE oauth2_registered_client
--(
--    id                            varchar(100)                            NOT NULL,
--    client_id                     varchar(100)                            NOT NULL,
--    client_id_issued_at           timestamp     DEFAULT CURRENT_TIMESTAMP NOT NULL,
--    client_secret                 varchar(200)  DEFAULT NULL,
--    client_secret_expires_at      timestamp     DEFAULT NULL,
--    client_name                   varchar(200)                            NOT NULL,
--    client_authentication_methods varchar(1000)                           NOT NULL,
--    authorization_grant_types     varchar(1000)                           NOT NULL,
--    redirect_uris                 varchar(1000) DEFAULT NULL,
--    post_logout_redirect_uris     varchar(1000) DEFAULT NULL,
--    scopes                        varchar(1000)                           NOT NULL,
--    client_settings               varchar(2000)                           NOT NULL,
--    token_settings                varchar(2000)                           NOT NULL,
--    PRIMARY KEY (id)
--);


---POSTGRES
-- Table: oauth2_authorization
CREATE TABLE oauth2_authorization
(
    id                            VARCHAR(100) PRIMARY KEY,
    registered_client_id          VARCHAR(100) NOT NULL,
    principal_name                VARCHAR(200) NOT NULL,
    authorization_grant_type      VARCHAR(100) NOT NULL,
    authorized_scopes             VARCHAR(1000) DEFAULT NULL,
--    attributes                    VARCHAR(50000) DEFAULT NULL,
attributes                         VARCHAR(50000),
    state                         VARCHAR(500) DEFAULT NULL,
    authorization_code_value      VARCHAR(50000) DEFAULT NULL,
    authorization_code_issued_at  TIMESTAMP DEFAULT NULL,
    authorization_code_expires_at TIMESTAMP DEFAULT NULL,
    authorization_code_metadata   VARCHAR(50000) DEFAULT NULL,
    access_token_value            VARCHAR(50000) DEFAULT NULL,
    access_token_issued_at        TIMESTAMP DEFAULT NULL,
    access_token_expires_at       TIMESTAMP DEFAULT NULL,
    access_token_metadata         VARCHAR(50000) DEFAULT NULL,
    access_token_type             VARCHAR(100) DEFAULT NULL,
    access_token_scopes           VARCHAR(1000) DEFAULT NULL,
    oidc_id_token_value           VARCHAR(50000) DEFAULT NULL,
    oidc_id_token_issued_at       TIMESTAMP DEFAULT NULL,
    oidc_id_token_expires_at      TIMESTAMP DEFAULT NULL,
    oidc_id_token_metadata        VARCHAR(50000) DEFAULT NULL,
    refresh_token_value           VARCHAR(50000) DEFAULT NULL,
    refresh_token_issued_at       TIMESTAMP DEFAULT NULL,
    refresh_token_expires_at      TIMESTAMP DEFAULT NULL,
    refresh_token_metadata        VARCHAR(50000) DEFAULT NULL,
    user_code_value               VARCHAR(50000) DEFAULT NULL,
    user_code_issued_at           TIMESTAMP DEFAULT NULL,
    user_code_expires_at          TIMESTAMP DEFAULT NULL,
    user_code_metadata            VARCHAR(50000) DEFAULT NULL,
    device_code_value             VARCHAR(50000) DEFAULT NULL,
    device_code_issued_at         TIMESTAMP DEFAULT NULL,
    device_code_expires_at        TIMESTAMP DEFAULT NULL,
    device_code_metadata          VARCHAR(50000) DEFAULT NULL
);

-- Table: oauth2_authorization_consent
CREATE TABLE oauth2_authorization_consent
(
    registered_client_id VARCHAR(100) NOT NULL,
    principal_name       VARCHAR(200) NOT NULL,
    authorities          VARCHAR(1000) NOT NULL,
    PRIMARY KEY (registered_client_id, principal_name)
);

-- Table: oauth2_registered_client
CREATE TABLE oauth2_registered_client
(
    id                            VARCHAR(100) PRIMARY KEY,
    client_id                     VARCHAR(100) NOT NULL,
    client_id_issued_at           TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    client_secret                 VARCHAR(200) DEFAULT NULL,
    client_secret_expires_at      TIMESTAMP DEFAULT NULL,
    client_name                   VARCHAR(200) NOT NULL,
    client_authentication_methods VARCHAR(1000) NOT NULL,
    authorization_grant_types     VARCHAR(1000) NOT NULL,
    redirect_uris                 VARCHAR(1000) DEFAULT NULL,
    post_logout_redirect_uris     VARCHAR(1000) DEFAULT NULL,
    scopes                        VARCHAR(1000) NOT NULL,
    client_settings               VARCHAR(2000) NOT NULL,
    token_settings                VARCHAR(2000) NOT NULL
);
