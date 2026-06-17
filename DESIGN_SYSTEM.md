# Hikari Design System

本规范基于当前 Android 资源与布局文件归纳，包括 `styles.xml`、`themes.xml`、`activity_main.xml`、`activity_settings.xml`、核心 drawable 与字符串资源。当前对话未提供实际截图，因此这里的“当前界面”指代码中已落地的界面结构与视觉参数。

## 1. 产品判断

### 产品气质

Hikari 是面向个人主页与状态页的设备状态同步工具。产品气质应是安静、可靠、轻量、可检查，而不是社交化、游戏化或强品牌叙事型应用。

- 适用场景：后台同步、授权、隐私、上传配置、状态预览等需要用户信任和复核的流程。
- 不要怎么用：不要使用大面积插画、强营销式标题、夸张动效、过饱和渐变或“炫技型”视觉包装。

### 目标用户

目标用户是自建网站、个人主页、仪表盘或自动化系统的技术型用户。他们关心权限边界、上传内容、同步稳定性和可控性。

- 适用场景：显示服务器地址、上传字段、Shizuku 授权状态、自动同步状态、隐私模式、前台应用过滤。
- 不要怎么用：不要隐藏关键配置，不要把风险说明做成模糊提示，不要用非技术化的模糊文案替代真实状态。

### 核心使用场景

1. 首次打开后确认 Shizuku 授权状态。
2. 配置服务器地址和上传策略。
3. 预览即将上传的数据。
4. 手动上传或开启自动同步。
5. 随时停止同步。

- 适用场景：所有主流程都应围绕“确认、配置、预览、执行、停止”展开。
- 不要怎么用：不要让自动同步入口比停止入口更容易误触；不要把预览和配置藏到次级页面深处。

## 2. 当前视觉语言提炼

### 色彩

当前使用 Material 3 / Material You 动态色，核心颜色来自系统主题属性：

- 页面背景：`colorSurface`
- 卡片背景：`colorSurfaceContainer`
- 预览行与输入框背景：`colorSurfaceContainerHigh`
- 分段控件轨道：`colorPrimaryContainer`
- 主按钮与选中态：`colorPrimary`
- 主文字：`colorOnSurface`
- 次级文字：`colorOnSurfaceVariant`
- 图标容器：`colorSecondaryContainer`

- 适用场景：所有常规界面优先使用系统动态色 token，保持浅色/深色模式自动适配。
- 不要怎么用：不要硬编码品牌色覆盖 Material You；不要在同一页面引入新的高饱和强调色。

### 字体

当前界面使用 Android 默认 sans-serif，字号集中在 13sp、14sp、16sp、26sp。

- 页面标题：26sp
- 卡片标题：16sp
- 正文与按钮：14sp
- 辅助标签：13sp

- 适用场景：工具型信息界面使用克制字号层级，减少视觉噪音。
- 不要怎么用：不要使用大标题英雄区；不要用小于 13sp 的核心信息；不要使用负字距。

### 间距

当前主页面与设置页具有稳定的密度：

- 页面左右边距：22dp
- 顶部栏内容高度：64dp
- 滚动内容顶部：8dp
- 滚动内容底部：28dp
- 卡片间距：12dp
- 卡片内边距：16dp 横向，20dp 纵向
- 图标与文字间距：16dp
- 标题与说明间距：5dp
- 主操作与卡片头部间距：16-18dp

- 适用场景：设置页、状态页、列表页都使用同一密度，让用户能快速扫描。
- 不要怎么用：不要随意引入 10dp、14dp、17dp 等零散间距；不要让相邻卡片间距大于卡片内距。

### 圆角、阴影与边框

当前界面以大圆角、低阴影为主：

- 卡片圆角：26dp
- 按钮圆角：20dp
- 输入框圆角：20dp
- 预览行圆角：18dp
- 分段控件轨道圆角：22dp
- 分段选中态圆角：20dp
- 卡片阴影：0dp
- 卡片描边：0dp
- 输入框聚焦描边：1dp

- 适用场景：移动端工具应用，使用填充色块建立层级。
- 不要怎么用：不要使用厚重投影；不要混用直角卡片和大圆角按钮；不要给所有容器都加边框。

### 组件风格

当前组件偏 Material 3：

- Filled Card 承载状态组、同步组、预览组、设置组。
- Filled Button 承载主要操作。
- Text Button Icon 承载顶部返回与设置。
- Filled TextInputLayout 承载设置输入。
- MaterialSwitch 承载隐私模式。
- 自定义 Segmented Control 承载前台应用过滤模式。

- 适用场景：任务型页面按“卡片分组 + 明确操作 + 原地状态反馈”组织。
- 不要怎么用：不要把多个复杂任务塞进一个卡片；不要让纯文本充当按钮；不要使用不带图标的陌生图形按钮。

## 3. Design System 规范

## 3.1 设计原则

### 原则 A：状态先于装饰

界面应优先回答“现在是否已授权、将上传什么、同步是否在运行”。

- 适用场景：授权卡片、同步卡片、上传预览、通知文案。
- 不要怎么用：不要用装饰性标题或图片挤占状态信息；不要把关键状态只放在 toast 里。

### 原则 B：每个后台动作都必须可停止

自动同步属于持续后台行为，停止入口必须清晰。

- 适用场景：首页同步卡片、前台服务通知、权限说明。
- 不要怎么用：不要只在通知里提供停止；不要把停止按钮做成弱提示链接。

### 原则 C：配置必须可复核

用户填写的服务器地址、上传间隔、过滤规则应易读、可改、可验证。

- 适用场景：设置页、上传预览、前台应用名单。
- 不要怎么用：不要把配置项压缩到难以点击的密集列表；不要隐藏单位。

### 原则 D：动态色负责品牌，结构负责识别

Hikari 使用 Material You 动态色，不依赖固定品牌色表达身份。品牌识别来自布局、圆角、图标容器、信息密度和文案语气。

- 适用场景：主题色、按钮、分段控件、图标 tint。
- 不要怎么用：不要为了品牌感硬编码紫色、蓝色或渐变背景。

## 3.2 色彩系统

### Surface 层级

- `surface/base`：页面背景，映射 `colorSurface`。
- `surface/card`：卡片背景，映射 `colorSurfaceContainer`。
- `surface/raised`：输入框、预览行背景，映射 `colorSurfaceContainerHigh`。
- `surface/highest`：未选中开关轨道，映射 `colorSurfaceContainerHighest`。

- 适用场景：页面、卡片、输入、预览行之间建立轻层级。
- 不要怎么用：不要用纯白或纯黑替代 surface token；不要让预览行背景比主卡片更抢眼。

### Content 层级

- `content/primary`：标题与关键数值，映射 `colorOnSurface`。
- `content/secondary`：说明、时间、状态描述，映射 `colorOnSurfaceVariant`。
- `content/accent`：字段标签与重点标签，映射 `colorPrimary`。
- `content/on-accent`：主按钮文字和图标，映射 `colorOnPrimary`。

- 适用场景：可读文本层级、按钮内容、字段标签。
- 不要怎么用：不要用 primary 色渲染整段正文；不要用 secondary 色显示危险或失败状态。

### Action 层级

- `action/primary`：开启同步、立即上传、刷新、授权。
- `action/stop`：停止同步，当前代码暂用 primary，规范建议改为 `colorErrorContainer` 或 tonal destructive。
- `action/selected`：分段控件选中态，映射 `colorPrimary`。

- 适用场景：可执行动作与选中态。
- 不要怎么用：不要让“停止同步”和“开启自动同步”使用完全相同的视觉权重和颜色语义。

## 3.3 字体系统

### Type Scale

| Token | Android | 用途 |
| --- | --- | --- |
| `text/page-title` | 26sp | 页面标题，如 Hikari、设置 |
| `text/section-title` | 16sp | 卡片标题 |
| `text/body` | 14sp | 正文、说明、按钮 |
| `text/label` | 13sp | 字段标签 |

- 适用场景：所有页面统一使用这四级字号。
- 不要怎么用：不要临时增加 15sp、17sp、20sp；不要在卡片里使用 26sp。

### 字重

- 页面标题：常规或 medium，当前代码未显式指定。
- 卡片标题：常规。
- 分段控件：`sans-serif-medium`。
- 按钮：常规。

- 适用场景：技术型工具界面，以内容层级而非粗字重制造重点。
- 不要怎么用：不要大量使用 bold；不要通过字体粗细替代状态颜色。

## 3.4 间距与栅格

### 页面栅格

- 页面左右 padding：22dp。
- 顶部栏内容高度：64dp。
- 内容区顶部 offset：8dp。
- 内容区底部 padding：28dp。

- 适用场景：手机端单列页面。
- 不要怎么用：不要在页面级使用居中窄栏；不要让内容贴边。

### 组件间距

- 卡片之间：12dp。
- 卡片内边距：16dp 横向、20dp 纵向。
- 图标与文字：16dp。
- 标题与说明：5dp。
- 主操作距卡片头部：16-18dp。
- 同组按钮间距：8dp。

- 适用场景：卡片内操作、表单项、预览项。
- 不要怎么用：不要让按钮与标题贴在一起；不要把不同组之间的间距做得比同组还小。

## 3.5 圆角、边框、阴影

### 圆角

- `radius/card`: 26dp。
- `radius/control`: 20dp。
- `radius/row`: 18dp。
- `radius/pill-track`: 22dp。
- `radius/icon`: 999dp 圆形。

- 适用场景：卡片、按钮、输入、分段控件、图标容器。
- 不要怎么用：不要引入 4dp/8dp 的小圆角卡片；不要把图标容器做成方形。

### 边框

- 卡片默认无描边。
- 输入框默认无描边，聚焦时 1dp primary。
- 错误输入使用 error stroke 与 error text。

- 适用场景：可编辑控件、错误状态。
- 不要怎么用：不要给普通信息卡片加描边；不要用粗描边表达选中。

### 阴影

- 卡片与顶部栏默认 0dp elevation。
- 顶部栏滚动后只变更背景色，不加投影。

- 适用场景：安静的工具型页面。
- 不要怎么用：不要使用悬浮卡片阴影堆叠页面；不要用阴影替代背景层级。

## 3.6 核心组件规范

### 顶部栏

- 高度：64dp。
- 左右 padding：22dp。
- 背景：未滚动 `colorSurface`，滚动后 `colorSurfaceContainer`。
- 首页右侧使用 40dp 图标按钮；二级页左侧使用 40dp 返回按钮。

- 适用场景：首页、设置页、应用选择页。
- 不要怎么用：不要加入副标题、搜索框或多按钮堆叠；不要用投影制造分隔。

### 信息卡片

- 背景：`colorSurfaceContainer`。
- 圆角：26dp。
- 内边距：16dp / 20dp。
- 标题 16sp，说明 14sp。
- 如有图标，使用 40dp 圆形容器，图标 24dp 内视觉尺寸。

- 适用场景：授权状态、同步操作、预览、设置分组。
- 不要怎么用：不要卡片套卡片；不要把超过 2 个任务塞进一个卡片。

### 主按钮

- 高度：40dp。
- 最小宽度：96dp。
- 圆角：20dp。
- 字号：14sp。
- 图标：18dp，图标与文字间距 10dp。

- 适用场景：开启同步、立即上传、刷新、保存、授权。
- 不要怎么用：不要在同一卡片放 3 个同等 primary 按钮作为长期形态；不要让危险动作使用普通 primary 颜色。

### 停止同步按钮

- 应使用独立语义：推荐 error tonal 或 outlined destructive。
- 图标使用 stop 方形符号。
- 文案固定为“停止同步”。

- 适用场景：自动同步已启动、通知 action、首页同步卡片。
- 不要怎么用：不要和“开启自动同步”完全同色同权重；不要隐藏到更多菜单。

### 输入框

- 使用 Filled TextInputLayout。
- 背景：`colorSurfaceContainerHigh`。
- 高度不低于 52dp。
- 圆角：20dp。
- 聚焦描边：1dp primary。
- 清除按钮和密码按钮使用 Material end icon。

- 适用场景：服务器地址、上传密钥、上传间隔、展示延迟、搜索。
- 不要怎么用：不要显示会遮挡清除按钮的错误图标；不要使用裸 EditText。

### 开关

- 高度：40dp。
- 选中轨道：primary。
- 未选中轨道：surface container highest。
- 选中 thumb：onPrimary。
- 未选中 thumb：outline。

- 适用场景：隐私模式、二元配置。
- 不要怎么用：不要用普通按钮表示二元状态；不要把开关文字塞进 switch 内部。

### 分段控件

- 高度：44dp。
- 外层圆角：22dp。
- 内层选中圆角：20dp。
- 外层背景：primaryContainer。
- 选中背景：primary。
- 文本：14sp medium。

- 适用场景：互斥模式，如关闭过滤/黑名单/白名单。
- 不要怎么用：不要用于超过 3 个选项；不要用于非互斥动作。

### 预览行

- 背景：surface container high。
- 圆角：18dp。
- 内边距：13dp。
- 标签：13sp primary。
- 值：14sp onSurfaceVariant，顶部间距 6dp。

- 适用场景：上传 payload 字段预览。
- 不要怎么用：不要用表格线分隔；不要让长文本无限扩展，应截断或折叠。

## 3.7 状态规范

### 授权状态

- 已授权：正文说明即可，可使用 verified 图标。
- 需要授权：显示授权按钮。
- Shizuku 未运行：显示不可用状态和可恢复说明。

- 适用场景：授权卡片、设置页授权区。
- 不要怎么用：不要只 toast 一次后让状态消失；不要用绿色/红色大面积铺满卡片。

### 加载状态

- 预览读取时字段值显示“正在读取状态…”。
- 刷新按钮暂时 disabled。

- 适用场景：状态预览、立即上传排队。
- 不要怎么用：不要在整页显示阻塞加载；不要隐藏已有内容。

### 错误状态

- 表单错误显示在输入框下方，使用 error 文本和 1dp error stroke。
- 上传失败应显示可读失败原因。

- 适用场景：URL 校验、分钟数校验、上传失败。
- 不要怎么用：不要只显示“失败”；不要使用系统异常原文直接面对用户。

### 空状态

- 上传预览未授权前显示等待文案。
- 前台应用名单为空时显示“未选择应用”。

- 适用场景：首次使用、空名单、无数据预览。
- 不要怎么用：不要留空白；不要用插画替代可执行下一步。

## 3.8 图标/插画规范

### 图标

- 使用 Material 风格线性图标。
- 顶部栏图标按钮：22dp。
- 主按钮图标：18dp。
- 卡片图标：放在 40dp 圆形 secondaryContainer 内，图标 tint primary。

- 适用场景：设置、返回、上传、刷新、开始、停止、授权、预览。
- 不要怎么用：不要混用 filled、duotone、彩色图标；不要使用无法在 18dp 下识别的复杂图标。

### 插画

Hikari 当前不需要常规插画。品牌图标可以出现在 README、关于页或启动图标，不进入任务主流程。

- 适用场景：仓库 README、空安装说明、关于页。
- 不要怎么用：不要在首页加入装饰插画；不要用背景图降低可读性。

## 3.9 文案语气规范

### 语气

文案应直接、准确、低情绪。优先说明状态、动作和后果。

- 适用场景：授权、上传、隐私、同步、失败说明。
- 不要怎么用：不要使用营销语、拟人化口吻或过度鼓励语。

### 按钮文案

- 使用动宾短语：开启自动同步、停止同步、立即上传、刷新当前数据、打开设置。
- 危险或持续性动作必须写清动作结果。

- 适用场景：所有按钮与通知 action。
- 不要怎么用：不要使用“确定”“好的”“开始”等上下文不足的词。

### 状态文案

- 使用事实描述：已获得 Shizuku 授权、Shizuku 未运行、已加入上传队列。

- 适用场景：卡片状态、toast、通知。
- 不要怎么用：不要省略主体；不要把错误归因给用户。

## 3.10 禁用规则 / 设计红线

1. 不要把自动同步设计成不可见、不可停。
2. 不要隐藏上传 payload 预览。
3. 不要用硬编码品牌色破坏 Material You。
4. 不要使用卡片套卡片。
5. 不要让停止同步与开启同步完全同色同权重。
6. 不要使用厚投影、渐变背景或装饰性大图。
7. 不要使用负字距或随视口缩放字号。
8. 不要让输入错误图标遮挡清除按钮或密码按钮。
9. 不要只用 toast 承载关键状态。
10. 不要在设置页引入隐藏式高级配置，除非它有清晰说明。

## 4. 当前 App 不一致点

以下问题来自当前资源与布局归纳，建议后续 UI 迭代继续关注：

1. 圆角体系略分散：26dp、22dp、20dp、18dp、999dp 并存。
   - 影响：虽然视觉接近，但 token 命名需收敛。
   - 建议：保留 card 26、control 20、row 18、pill 999 四档。

2. 部分文本显式字体，部分文本依赖系统默认。
   - 影响：跨设备可能出现微妙差异。
   - 建议：为标题、正文、按钮、标签建立统一 style。

3. 状态没有颜色语义。
   - 影响：授权、失败、同步中主要依赖文字。
   - 建议：增加 success/warning/error 的低饱和容器色，但不要大面积使用。

4. 卡片圆角 26dp 偏大。
   - 影响：工具应用密度略低。
   - 建议：若未来增加更多设置项，可评估降至 20dp 或 22dp。

## 5. Design Tokens

### CSS Variables

```css
:root {
  /* Color aliases. Map these to Material 3 dynamic colors in Android. */
  --hikari-color-surface: var(--md-sys-color-surface);
  --hikari-color-surface-card: var(--md-sys-color-surface-container);
  --hikari-color-surface-raised: var(--md-sys-color-surface-container-high);
  --hikari-color-surface-highest: var(--md-sys-color-surface-container-highest);
  --hikari-color-primary: var(--md-sys-color-primary);
  --hikari-color-primary-container: var(--md-sys-color-primary-container);
  --hikari-color-secondary-container: var(--md-sys-color-secondary-container);
  --hikari-color-error: var(--md-sys-color-error);
  --hikari-color-error-container: var(--md-sys-color-error-container);
  --hikari-color-on-surface: var(--md-sys-color-on-surface);
  --hikari-color-on-surface-variant: var(--md-sys-color-on-surface-variant);
  --hikari-color-on-primary: var(--md-sys-color-on-primary);
  --hikari-color-outline: var(--md-sys-color-outline);

  /* Typography */
  --hikari-font-family: system-ui, -apple-system, BlinkMacSystemFont, "Segoe UI", sans-serif;
  --hikari-font-size-page-title: 26px;
  --hikari-font-size-section-title: 16px;
  --hikari-font-size-body: 14px;
  --hikari-font-size-label: 13px;
  --hikari-letter-spacing: 0;

  /* Spacing */
  --hikari-space-1: 4px;
  --hikari-space-2: 5px;
  --hikari-space-3: 6px;
  --hikari-space-4: 8px;
  --hikari-space-5: 12px;
  --hikari-space-6: 13px;
  --hikari-space-7: 16px;
  --hikari-space-8: 18px;
  --hikari-space-9: 20px;
  --hikari-space-page-x: 22px;
  --hikari-space-page-bottom: 28px;

  /* Size */
  --hikari-size-topbar: 64px;
  --hikari-size-button-height: 40px;
  --hikari-size-button-min-width: 96px;
  --hikari-size-input-min-height: 52px;
  --hikari-size-icon-container: 40px;
  --hikari-size-icon-topbar: 22px;
  --hikari-size-icon-button: 18px;
  --hikari-size-segmented-height: 44px;

  /* Radius */
  --hikari-radius-card: 26px;
  --hikari-radius-pill-track: 22px;
  --hikari-radius-control: 20px;
  --hikari-radius-row: 18px;
  --hikari-radius-full: 999px;

  /* Border and elevation */
  --hikari-border-width-focus: 1px;
  --hikari-elevation-card: 0;
  --hikari-elevation-topbar: 0;
}
```

### Tailwind Config

```js
/** @type {import('tailwindcss').Config} */
export default {
  theme: {
    extend: {
      colors: {
        hikari: {
          surface: 'var(--hikari-color-surface)',
          card: 'var(--hikari-color-surface-card)',
          raised: 'var(--hikari-color-surface-raised)',
          primary: 'var(--hikari-color-primary)',
          primaryContainer: 'var(--hikari-color-primary-container)',
          secondaryContainer: 'var(--hikari-color-secondary-container)',
          error: 'var(--hikari-color-error)',
          errorContainer: 'var(--hikari-color-error-container)',
          onSurface: 'var(--hikari-color-on-surface)',
          onSurfaceVariant: 'var(--hikari-color-on-surface-variant)',
          onPrimary: 'var(--hikari-color-on-primary)',
          outline: 'var(--hikari-color-outline)',
        },
      },
      fontFamily: {
        hikari: ['system-ui', '-apple-system', 'BlinkMacSystemFont', '"Segoe UI"', 'sans-serif'],
      },
      fontSize: {
        'hikari-page': ['26px', { lineHeight: '32px', letterSpacing: '0' }],
        'hikari-title': ['16px', { lineHeight: '22px', letterSpacing: '0' }],
        'hikari-body': ['14px', { lineHeight: '20px', letterSpacing: '0' }],
        'hikari-label': ['13px', { lineHeight: '18px', letterSpacing: '0' }],
      },
      spacing: {
        'hikari-page-x': '22px',
        'hikari-page-bottom': '28px',
        'hikari-card-x': '16px',
        'hikari-card-y': '20px',
        'hikari-card-gap': '12px',
        'hikari-title-gap': '5px',
        'hikari-action-gap': '8px',
      },
      borderRadius: {
        'hikari-card': '26px',
        'hikari-track': '22px',
        'hikari-control': '20px',
        'hikari-row': '18px',
        'hikari-full': '999px',
      },
      boxShadow: {
        hikari: 'none',
      },
      minWidth: {
        'hikari-button': '96px',
      },
      height: {
        'hikari-topbar': '64px',
        'hikari-button': '40px',
        'hikari-input': '52px',
        'hikari-icon': '40px',
        'hikari-segmented': '44px',
      },
    },
  },
};
```

### Android Token Mapping

| Design Token | Android Resource / Attribute |
| --- | --- |
| `surface/base` | `?attr/colorSurface` |
| `surface/card` | `?attr/colorSurfaceContainer` |
| `surface/raised` | `?attr/colorSurfaceContainerHigh` |
| `action/primary` | `?attr/colorPrimary` |
| `content/primary` | `?attr/colorOnSurface` |
| `content/secondary` | `?attr/colorOnSurfaceVariant` |
| `radius/card` | `26dp` |
| `radius/control` | `20dp` |
| `radius/row` | `18dp` |
| `space/page-x` | `22dp` |
| `size/topbar` | `64dp` |
| `size/button-height` | `40dp` |
