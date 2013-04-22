# Manifest file for Debian Box, SLIM project

node default {

  notify {"Preparing debianbox for SLIM project.":}
  notify {"Starting installation of CouchDB.":}

  class { 'couchdb':
    bind => '0.0.0.0'
  }

}

