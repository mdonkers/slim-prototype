class network (
  $style,
  $ip = '10.10.10.101',
  $netmask = '255.255.255.0'
) {

  file { '/etc/network/interfaces':
    ensure  => file,
    owner => root,
    group => root,
    mode => 644,
    content => template("network/$style")
  }

  exec { 'interface_up':
    command => "/sbin/ifup eth1",
    unless  => "/sbin/ifconfig | grep eth1",
    require => File['/etc/network/interfaces'],
  }

}
