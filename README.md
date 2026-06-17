# Hikari

<p align="center">
  <img src="docs/assets/Hikari.png" width="120" alt="Hikari icon">
</p>

<p align="center">
  <strong>Hikari</strong>
</p>

<p align="center">
  <a href="docs/README.md">English</a> | 简体中文
</p>

Hikari 是一款使用 Shizuku 采集并上传设备状态的 Android 应用，面向个人主页、仪表盘和状态页。

当前包名为 `cafe.miafetta.hikari`，当前版本为 `2.0`。

## 概览

- 通过 Shizuku 读取设备型号、电池、网络、Wi-Fi、定位和前台应用信息。
- 在首页预览实际上传字段。
- 支持手动上传和前台服务自动同步。
- 支持前台应用黑名单/白名单过滤。
- 选择前台应用时会显示系统应用列表读取进度。
- 支持通知中的停止自动同步，以及首页中的停止自动同步按钮。
- 支持 Android 12+ 动态颜色和浅色/深色模式。

## 快速开始

1. 安装并启动 Shizuku。
2. 为 Hikari 授权 Shizuku。
3. 在设置中填写服务器 API 地址。
4. 使用下面的命令构建调试版：

```powershell
.\gradlew.bat :app:assembleDebug
```

## 文档

- [英文文档](docs/README.md)
- [设计系统](DESIGN_SYSTEM.md)
- [使用说明](docs/USAGE.md)
- [构建说明](docs/BUILDING.md)
- [架构说明](docs/ARCHITECTURE.md)
- [发布说明](docs/RELEASES.md)
- [贡献指南](CONTRIBUTING.md)
- [安全政策](SECURITY.md)
- [变更记录](CHANGELOG.md)

## 仓库结构

```text
app/                     Android 应用源码与资源
docs/                    英文文档和补充说明
.github/                 Issue 和 Pull Request 模板
CONTRIBUTING.md          贡献流程
SECURITY.md              安全漏洞报告方式
CHANGELOG.md             变更记录
LICENSE                  开源许可证
```

## 相关项目

```text
Miafetta/hikari-android  <- 当前项目
        |
        | 上传状态
        v
Miafetta/hikari-api
        |
        | 输出清洗后的状态 JSON
        v
Miafetta/miafetta.github.io
```

- [Miafetta/hikari-android](https://github.com/Miafetta/hikari-android)：Android 状态采集与上传端，当前项目。
- [Miafetta/hikari-api](https://github.com/Miafetta/hikari-api)：状态数据处理 API。
- [Miafetta/miafetta.github.io](https://github.com/Miafetta/miafetta.github.io)：博客展示端。

## 隐私

Hikari 会读取并上传原始设备状态，包括设备型号、电池输出、网络状态、前台应用名称和最近定位输出等。开启自动同步前，请先在应用内检查上传数据预览。

请仅上传到你自己控制并信任的服务器。

## 许可证

Hikari 使用 GNU General Public License v3.0 开源许可证。详情请查看 [LICENSE](LICENSE)。
