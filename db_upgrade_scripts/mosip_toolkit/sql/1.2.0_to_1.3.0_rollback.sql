\c mosip_toolkit sysadmin

DROP TABLE IF EXISTS toolkit.datashare_tokens;
ALTER TABLE toolkit.abis_projects DROP COLUMN modality;
COMMENT ON COLUMN toolkit.abis_projects.modality IS NULL;

ALTER TABLE toolkit.sbi_projects DROP COLUMN device_image1;
ALTER TABLE toolkit.sbi_projects DROP COLUMN device_image2;
ALTER TABLE toolkit.sbi_projects DROP COLUMN device_image3;
ALTER TABLE toolkit.sbi_projects DROP COLUMN device_image4;
ALTER TABLE toolkit.sbi_projects DROP COLUMN sbi_hash;
ALTER TABLE toolkit.sbi_projects DROP COLUMN website_url;
COMMENT ON COLUMN toolkit.sbi_projects.device_image1 IS NULL;
COMMENT ON COLUMN toolkit.sbi_projects.device_image2 IS NULL;
COMMENT ON COLUMN toolkit.sbi_projects.device_image3 IS NULL;
COMMENT ON COLUMN toolkit.sbi_projects.device_image4 IS NULL;
COMMENT ON COLUMN toolkit.sbi_projects.sbi_hash IS NULL;
COMMENT ON COLUMN toolkit.sbi_projects.website_url IS NULL;

ALTER TABLE toolkit.sdk_projects DROP COLUMN sdk_hash;
ALTER TABLE toolkit.sdk_projects DROP COLUMN website_url;
COMMENT ON COLUMN toolkit.sdk_projects.sdk_hash IS NULL;
COMMENT ON COLUMN toolkit.sdk_projects.website_url IS NULL;

ALTER TABLE toolkit.abis_projects DROP COLUMN abis_hash;
ALTER TABLE toolkit.abis_projects DROP COLUMN website_url;
COMMENT ON COLUMN toolkit.abis_projects.abis_hash IS NULL;
COMMENT ON COLUMN toolkit.abis_projects.website_url IS NULL;