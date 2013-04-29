# Manifest file for Debian Box, SLIM project

node default {

  notify {"Preparing debianbox for SLIM project.":}
  notify {"Starting installation of CouchDB.":}

  class { 'network':
    style => nat_and_hostonly,
    ip => '10.10.10.101'
  }

  class { 'couchdb':
    bind => '10.10.10.101',
    require => Class['network']
  }

}

