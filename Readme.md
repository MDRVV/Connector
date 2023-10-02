# Connector
 Connector - это модуль-техзадание, в котором выполнен activity для запроса на подключение.
 Т.к. в качестве DI используется Koin, перед билдом рекоммендуется выполнить команду:
 `./gradlew :app:testDebugUnitTest --tests "com.rcl.connector.KoinCheck.checkKoinModule"`
 Выполнено с использованием кроссплатформенных библиотек, так что перевести на kmp/cmp рельсы не составило бы проблем